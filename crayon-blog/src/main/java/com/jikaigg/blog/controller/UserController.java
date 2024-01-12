package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.User;
import com.jikaigg.blog.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/register")
    public CrResult register(String username, String password) {
        // 查询用户是否存在
        User user = userService.findByUsername(username);
        if (user == null) {
            userService.register(username, password);
            return CrResult.success(null);
        } else {
            return CrResult.fail("40000001", "用户已存在");
        }
        // 注册

    }
}
