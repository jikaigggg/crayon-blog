package com.jikaigg.blog.service;

import com.jikaigg.blog.domain.User;

public interface UserService {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    User findByUsername(String username);

    /**
     * 用户注册
     *
     * @param username
     * @param password
     */
    void register(String username, String password);
}