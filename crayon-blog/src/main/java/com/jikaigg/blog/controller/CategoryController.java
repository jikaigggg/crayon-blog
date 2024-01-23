package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.Category;
import com.jikaigg.blog.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 新增文章分类
     * @param category
     * @return
     */
    @PostMapping
    public CrResult category(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return CrResult.success(null);
    }
}
