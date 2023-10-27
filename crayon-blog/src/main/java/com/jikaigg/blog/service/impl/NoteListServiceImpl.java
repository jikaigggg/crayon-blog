package com.jikaigg.blog.service.impl;

import com.jikaigg.blog.domain.CrArticle;
import com.jikaigg.blog.mapper.CrArticleMapper;
import com.jikaigg.blog.service.NoteListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : jikaigg
 * @Date : 2023/10/27
 */
@Service
public class NoteListServiceImpl implements NoteListService {

    @Resource
    private CrArticleMapper crArticleMapper;

    @Override
    public CrArticle selectByNoteId(Integer id) {
        return crArticleMapper.queryById(id);
    }

    @Override
    public List<CrArticle> selectAll() {
        return crArticleMapper.queryAllByLimit(null,null);
    }
}
