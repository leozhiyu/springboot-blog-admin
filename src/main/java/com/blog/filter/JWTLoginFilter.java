package com.blog.filter;


import com.blog.constant.JWTConstant;
import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.responsitory.UserRespository;
import com.blog.service.UserService;
import com.blog.util.JWTUtil;
import com.blog.util.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author yukong
 * @version V1.0
 * @Description: 验证用户名密码正确后，生成一个token，并将token返回给客户端
 *               该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 *               attemptAuthentication ：接收并解析用户凭证。
 *               successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 * @date 2018/5/13 16:39
 **/
@Slf4j
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {


    private AuthenticationManager authenticationManager;


    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        try {
            User user = new ObjectMapper().readValue(request.getInputStream(),User.class);
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUserName(),
                    user.getUserPwd(),
                    new ArrayList<>()
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException {


        String token = null;
        String username = null;
        log.debug("登录成功");
        try {
            username = ((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername();
            token = JWTUtil.createJWT(username, JWTConstant.JWT_TTL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //获取spring 容器 登录成功返回用户信息
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(req.getSession().getServletContext());
        UserRespository userResponsitory = webApplicationContext.getBean(UserRespository.class);
        res.setContentType("application/json;charset=utf-8");
        User user = userResponsitory.findByUserName(username);
        ObjectMapper objectMapper = new ObjectMapper();
        Result result = ResultUtil.success(user);
        res.getWriter().print(objectMapper.writeValueAsString(result));
        res.setHeader("Access-Control-Expose-Headers", "Authorization");
        res.addHeader("Authorization", token);
        res.getWriter().flush();
    }


    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.error("登录错误");

        response.setContentType("application/json;charset=utf-8");
        ObjectMapper objectMapper = new ObjectMapper();
        Result result = ResultUtil.error(failed.getMessage());
        response.getWriter().print(objectMapper.writeValueAsString(result));
        response.getWriter().flush();
    }

}
