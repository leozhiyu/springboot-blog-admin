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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserResponsitory userResponsitory;

    /**
     * 用户登录
     * @return
     */
    public Result login(String username, String password) {
        // 注意此处使用 findOne，如果使用 getOne 可能会报错，getOne 返回的是一个代理对象，与Hibernate有关，我也还不知道具体原理
        User user = userResponsitory.getOnlyOneUser();
        if (user != null) {
            return ResultUtil.success("成功获取用户信息", user);
        }
        return ResultUtil.error("获取用户信息失败");
    }
}
