package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);

    int add(String username,String password);

    int update(User user);

    int updateAvatar(Integer id ,String avatarUrl);

    int updatePwd(Integer id,String md5String);
}
