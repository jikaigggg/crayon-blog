package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {
    int add(Category category);

    List<Category> list(Integer id);

    int update(Category category);

    int delete(Integer id);
}
