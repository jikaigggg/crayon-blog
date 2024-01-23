package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.Category;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    int add(Category category);
}
