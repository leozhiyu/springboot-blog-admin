/**
 * @author:Leo
 * @create 2018/4/24
 * @desc User Service层
 */
package com.blog.service;

import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.responsitory.UserResponsitory;
import com.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserResponsitory userResponsitory;

    private static final Md5PasswordEncoder ENCODER = new Md5PasswordEncoder();

    /**
     * 注册新用户，页面不提供该功能
     * @param user
     * @return
     */
    public Result regist(User user) {
        if (userResponsitory.findByUserName(user.getUserName()) == null) {
            // 密码加密
            String encodedPwd = ENCODER.encodePassword(user.getUserPwd(), user.getUserName());
            user.setUserPwd(encodedPwd);
            // 新增用户记录
            User resUser = userResponsitory.save(user);
            LOGGER.info("注册成功");
            return ResultUtil.success("注册成功", resUser);
        }
        LOGGER.error("用户名已存在");
        return ResultUtil.error("用户名已存在");
    }


    /**
     * 用户登录
     * @return
     */
    public Result login(String userName, String password) {
        User user = userResponsitory.findByUserName(userName);
        if (user != null) {
            return ENCODER.isPasswordValid(user.getUserPwd(), password, userName)
                    ? ResultUtil.success("用户登录成功了吗", user.getUserName())
                    : ResultUtil.error("密码错误");
        }
        return ResultUtil.error("该用户不存在");
    }
}
