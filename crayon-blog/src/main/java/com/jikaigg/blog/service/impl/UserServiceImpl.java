package com.jikaigg.blog.service.impl;

import com.jikaigg.blog.domain.User;
import com.jikaigg.blog.mapper.UserMapper;
import com.jikaigg.blog.service.UserService;
import com.jikaigg.blog.utils.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
