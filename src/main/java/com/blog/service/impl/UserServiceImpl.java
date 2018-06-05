/**
 * @author:Leo
 * @create 2018/4/24
 * @desc User Service层
 */
package com.blog.service.impl;

import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.responsitory.UserRespository;
import com.blog.service.UserService;
import com.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRespository userResponsitory;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 注册新用户，页面不提供该功能
     * @param user
     * @return
     */
    @Override
    public Result register(User user) {
        if (userResponsitory.findByUserName(user.getUserName()) == null) {
            // 新增用户记录
            user.setUserPwd(
                    bCryptPasswordEncoder.encode(user.getUserPwd())
            );
            User resUser = userResponsitory.save(user);
            LOGGER.info("注册成功");
            return ResultUtil.success("注册成功", resUser);
        }
        LOGGER.error("用户名已存在");
        return ResultUtil.error("用户名已存在");
    }


   /* *//**
     * 用户登录
     * @return
     *//*
    public Result login(String userName, String password) {
        User user = userResponsitory.findByUserName(userName);
        if (user != null) {
            return ENCODER.isPasswordValid(user.getUserPwd(), password, userName)
                    ? ResultUtil.success("用户登录成功了吗", user.getUserName())
                    : ResultUtil.error("密码错误");
        }
        return ResultUtil.error("该用户不存在");
    }*/
}
