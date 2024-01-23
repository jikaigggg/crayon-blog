package com.jikaigg.blog.service.impl;

import com.jikaigg.blog.domain.Category;
import com.jikaigg.blog.mapper.CategoryMapper;
import com.jikaigg.blog.service.CategoryService;
import com.jikaigg.blog.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        category.setCreateUser(id);
        categoryMapper.add(category);
    }
}
