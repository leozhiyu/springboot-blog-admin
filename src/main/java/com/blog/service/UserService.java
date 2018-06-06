/**
 * @author:Leo
 * @create 2018/4/24
 * @desc User Service层
 */
package com.blog.service;

import com.blog.domain.Result;
import com.blog.domain.User;
import com.blog.responsitory.UserRespository;
import com.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


public interface UserService {
    /**
     * 注册新用户，页面不提供该功能
     * @param user
     * @return
     */
    public Result register(User user) ;


}
