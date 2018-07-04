/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 */
package com.blog.controller;

import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.service.UserService;
import com.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 博客用户注册
     * @param user
     * @return
     */
    @PostMapping(value = "/user")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    @GetMapping(value = "/user/{id}")
    public Result getById(@PathVariable Integer id) { return ResultUtil.success(userService.findUserById(id));}
}
