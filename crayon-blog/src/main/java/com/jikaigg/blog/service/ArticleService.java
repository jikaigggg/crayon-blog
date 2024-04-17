package com.jikaigg.blog.service;

import com.jikaigg.blog.domain.Article;
import com.jikaigg.blog.domain.CrResponse;

import java.util.List;

public interface ArticleService {
    int add(Article article);

    CrResponse<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state);

    Article detail(Integer id);

    int update(Article article);

    int delete(Integer id);
}
