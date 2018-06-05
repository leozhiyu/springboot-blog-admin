package com.blog.security;

import com.blog.responsitory.UserRespository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author yukong
 * @version V1.0
 * @Description: 继承spring security UserDetailService  重写loadUserByName 实现登录逻辑
 * @date 2018/5/14 09:54
 **/
@Component
@Slf4j
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRespository userResponsitory;

    public MyUserDetailServiceImpl( UserRespository userResponsitory) {
        this.userResponsitory = userResponsitory;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("【登录用户名】:" + username);
        com.blog.domain.User user = userResponsitory.findByUserName(username);
        if ( user == null ) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(username,
                user.getUserPwd(), true, true,
                true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}