package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.Category;
import com.jikaigg.blog.service.CategoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    /**
     * 新增文章分类
     *
     * @param category
     * @return
     */
    @PostMapping
    public CrResult category(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return CrResult.success(null);
    }

    /**
     * 获取文章分类信息
     *
     * @return
     */
    @GetMapping
    public CrResult categoryList() {
        List<Category> list = categoryService.list();
        return CrResult.success(list);
    }

    /**
     * 更新文章分类
     *
     * @param category
     * @return
     */
    @PutMapping
    public CrResult categoryUpdate(@RequestBody @Validated Category category) {
        categoryService.update(category);
        return CrResult.success(null);
    }

    /**
     * 更新文章分类
     *
     * @param category
     * @return
     */
    @DeleteMapping
    public CrResult categoryDelete(@RequestBody Category category) {
        Integer id = category.getId();
        if (id != null) {
            categoryService.delete(id);
            return CrResult.success(null);
        } else {
            return CrResult.fail("0000003", "分类编号不能为空");
        }
    }
}
