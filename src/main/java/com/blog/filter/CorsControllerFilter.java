package com.blog.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 *
 */
@Component
public class CorsControllerFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setContentType("text/html;charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE ,PUT");
        res.setHeader("Access-Control-Max-Age", "30");
        res.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since,"
                + " Pragma, Last-Modified, Cache-Control, Expires, Content-Type, "
                + "X-E4M-With,userId,token,Authorization,deviceId,Access-Control-Allow-Origin,Access-Control-Allow-Headers,Access-Control-Allow-Methods");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("XDomainRequestAllowed", "1");
        chain.doFilter(request, response);

    }

}