package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.User;
import com.jikaigg.blog.service.UserService;
import com.jikaigg.blog.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/user")
@RestController
@Validated
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 用户注册
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/register")
    public CrResult register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户是否存在
        User user = userService.findByUsername(username);
        if (user == null) {
            userService.register(username, password);
            return CrResult.success(null);
        } else {
            return CrResult.fail("40000001", "用户已存在");
        }
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public CrResult<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户是否存在
        User curUser = userService.findByUsername(username);
        if (curUser == null) {
            return CrResult.fail("000001", "用户不存在！");
        }
        // 校验密码是否正确
        if (Md5Util.getMD5String(password).equals(curUser.getPassword())) {
            // 返回JWT令牌
            return CrResult.success("jwt token ...");
        }
        return CrResult.fail("000002", "密码错误");

    }
}
