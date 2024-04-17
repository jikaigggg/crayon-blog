package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.Article;
import com.jikaigg.blog.domain.CrResponse;
import com.jikaigg.blog.service.ArticleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 文章操作
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * 新增文章
     *
     * @return
     */
    @PostMapping
    public CrResult<String> add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return CrResult.success(null);
    }

    /**
     * 分页获取文章查询结果
     *
     * @param pageNum
     * @param pageSize
     * @param categoryId
     * @param state
     * @return
     */
    @GetMapping
    public CrResult<CrResponse<Article>> list(
            Integer pageNum,
            Integer pageSize,
            @RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) String state
    ) {
        CrResponse<Article> list = articleService.list(pageNum, pageSize, categoryId, state);
        return CrResult.success(list);
    }

    /**
     * 获取文章详细信息
     *
     * @param id
     * @return
     */
    @GetMapping("/detail")
    public CrResult<Article> detail(Integer id) {
        Article article = articleService.detail(id);
        return CrResult.success(article);
    }

    /**
     * 更新文章
     *
     * @param article
     * @return
     */
    @PutMapping
    public CrResult update(@RequestBody @Validated Article article) {
        Integer id = article.getId();
        if (id == null) {
            return CrResult.fail("000001", "文章id不能为空");
        }
        articleService.update(article);
        return CrResult.success(null);
    }

    /**
     * 删除文章
     *
     * @param id
     * @return
     */
    @DeleteMapping
    public CrResult delete(@RequestParam("id") Integer id) {
        if (id == null) {
            return CrResult.fail("000001", "文章id不能为空");
        }
        articleService.delete(id);
        return CrResult.success(null);
    }
}
