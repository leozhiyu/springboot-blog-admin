/**
 * @author:Leo
 * @create 2018/4/24
 * @desc
 * User 持久化层
 */
package com.blog.responsitory;

import com.blog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserResponsitory extends JpaRepository<User,Integer> {

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    User findByUserName(String userName);
}
