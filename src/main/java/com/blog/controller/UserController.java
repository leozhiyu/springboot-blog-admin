/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 */
package com.blog.controller;

import com.blog.domain.Result;
import com.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 博客用户登录
     * @return
     */
    @PostMapping(value = "/user")
    public Result login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.login(username, password);
    }
}
