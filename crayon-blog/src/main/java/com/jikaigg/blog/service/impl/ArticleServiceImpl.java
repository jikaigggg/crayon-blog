package com.jikaigg.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jikaigg.blog.domain.Article;
import com.jikaigg.blog.domain.CrResponse;
import com.jikaigg.blog.mapper.ArticleMapper;
import com.jikaigg.blog.service.ArticleService;
import com.jikaigg.blog.utils.ThreadLocalUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 文章操作service
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleMapper articleMapper;

    @Override
    public int add(Article article) {
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        article.setCreateUser(id);
        return articleMapper.add(article);
    }

    @Override
    public CrResponse<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> claims = ThreadLocalUtil.get();
        Integer id = (Integer) claims.get("id");
        List<Article> articles = articleMapper.list(id, categoryId, state);
        Page<Article> articlePageInfo = (Page<Article>) articles;
        CrResponse<Article> objectCrResponse = new CrResponse<>();
        objectCrResponse.setTotal(articlePageInfo.getTotal());
        objectCrResponse.setItems(articlePageInfo.getResult());
        return objectCrResponse;
    }

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     */
    @Override
    public Article detail(Integer id) {
        Article article = articleMapper.selectById(id);
        return article;
    }

    @Override
    public int update(Article article) {
        Integer flag = articleMapper.update(article);
        return flag;

    }

    @Override
    public int delete(Integer id) {
        Integer flag = articleMapper.delete(id);
        return flag;
    }
}
