package com.jikaigg.blog.service;

import com.jikaigg.blog.domain.CrArticle;

import java.util.List;

/**
 * 文章列表
 *
 * @author : jikaigg
 * @Date : 2023/10/27
 */
public interface NoteListService {
    CrArticle selectByNoteId(Integer id);

    List<CrArticle> selectAll();
}
