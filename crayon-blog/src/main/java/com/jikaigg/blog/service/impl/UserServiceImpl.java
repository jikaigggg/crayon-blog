package com.jikaigg.blog.service.impl;

import com.jikaigg.blog.domain.User;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.service.UserService;
import com.jikaigg.blog.utils.Md5Util;
import com.jikaigg.blog.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户操作service
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(String username, String password) {
        // 密码加密
        String md5Password = Md5Util.getMD5String(password);
        userMapper.add(username, md5Password);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updateAvatar(id, avatarUrl);
    }

    @Override
    public void updatePwd(String newPwd) {
        String md5String = Md5Util.getMD5String(newPwd);
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        userMapper.updatePwd(id, md5String);
    }
}
