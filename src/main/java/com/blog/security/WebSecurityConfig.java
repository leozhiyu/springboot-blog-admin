/**
 * @author:Leo
 * @create 2018/4/25
 * @desc
 * 添加了spring-boot-starter-security依赖，整个应用就有了默认的认证安全机制
 * 通过继承 WebSecurityConfigurerAdapter 类定制用户名和密码
 */
package com.blog.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity //开启Spring Security功能
@EnableGlobalMethodSecurity(securedEnabled = true) //securedEnabled开启@Secured 注解过滤权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 在内存在创建一个用户，用户名为admin，密码为admin
        auth
                .inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("user");  // 必须得设置角色，否则会报错
    }
}
