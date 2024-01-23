package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.User;
import com.jikaigg.blog.service.UserService;
import com.jikaigg.blog.utils.JwtUtil;
import com.jikaigg.blog.utils.Md5Util;
import com.jikaigg.blog.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", curUser.getId());
            claims.put("username", curUser.getUsername());
            // 返回JWT令牌
            String token = JwtUtil.genToken(claims);
            return CrResult.success(token);
        }
        return CrResult.fail("000002", "密码错误");
    }

    /**
     * 根据用户名查询用户
     *
     * @return
     */
    @GetMapping("userInfo")
    public CrResult<User> userInfo() {
        // 从ThreadLocal中获取token解析的用户名查询详细用户信息
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User curUser = userService.findByUsername(username);
        return CrResult.success(curUser);

    }

    @PutMapping("update")
    public CrResult update(@RequestBody User user) {
        int update = userService.update(user);
        if (update == 1) {
            return CrResult.success(null);
        }
        return CrResult.fail("000009", "更新用户信息失败");

    }

    @PatchMapping("/updateAvatar")
    public CrResult updateAvatar(@RequestParam @URL String avatarUrl) {
        userService.updateAvatar(avatarUrl);
        return CrResult.success(null);
    }

    @PatchMapping("/updatePwd")
    public CrResult updatePwd(@RequestBody Map<String, String> params) {
        // 校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return CrResult.fail("00000009", "参数不能为空");
        }
        // 校验原密码是否准确
        Map<String, Object> claims = ThreadLocalUtil.get();
        String username = (String) claims.get("username");
        User curUser = userService.findByUsername(username);
        if (!curUser.getPassword().equals(Md5Util.getMD5String(oldPwd))) {
            return CrResult.fail("00000009", "原密码输入不正确");
        }
        if (!newPwd.equals(rePwd)){
            return CrResult.fail("00000009", "新密码两次输入不相同");
        }
        // 更新密码
        userService.updatePwd(newPwd);
        return CrResult.success(null);
    }
}
