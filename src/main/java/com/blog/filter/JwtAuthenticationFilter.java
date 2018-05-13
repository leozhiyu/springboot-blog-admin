package com.blog.filter;

import com.blog.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author yukong
 * @version V1.0
 * @Description: jwt token校验过滤器
 * @date 2018/5/14 10:01
 **/
@Slf4j
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {



    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        //从请求头获取jwt token
        String header = request.getHeader("Authorization");

        //判断是否存在jwt token
        if (StringUtils.isEmpty(header)) {
            //不存在 走其他的过滤器 比如  usernameAndPasswordFilter
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authenticationToken = null;
        try {
            //不为空 解密token
            authenticationToken = getUsernamePasswordAuthenticationToken(header);
        } catch (Exception e) {
            log.error("【获取登录token失败】： {}", e.getMessage());
        }

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) throws Exception {
        String user = JWTUtil.parseJWT(token).getSubject();

        if (null != user) {
            return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
        }

        return null;
    }
}
