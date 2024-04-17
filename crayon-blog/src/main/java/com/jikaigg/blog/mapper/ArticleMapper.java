package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.Article;
import com.jikaigg.blog.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {
    int add(Article article);

    List<Article> list(Integer id, Integer categoryId, String state);

    Article selectById(Integer id);

    int update(Article article);

    Integer delete(Integer id);
}
