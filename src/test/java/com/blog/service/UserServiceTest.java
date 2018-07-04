package com.blog.service;

import com.blog.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void regist() {
        User user = new User();
        user.setUserName("admin");
        user.setUserPwd("admin");
        user.setUserEmail("admin@admin.com");
        userService.register(user);
    }


    public static void main(String[] args) {
        a("a","b");
    }

    /*
    public static void a(String a, String b){
        System.out.println(1);
        System.out.println(a+b);
    }
*/

    public  static void a(String ...a){
        for (String as:a) {
            System.out.println(as);
        }
    }
}