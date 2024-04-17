package com.jikaigg.blog.service;

import com.jikaigg.blog.domain.Category;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    List<Category> list();

    int update(Category category);

    int delete(Integer id);
}
