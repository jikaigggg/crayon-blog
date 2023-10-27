package com.jikaigg.blog.controller;

import com.alibaba.fastjson.JSON;
import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.domain.CrArticle;
import com.jikaigg.blog.service.impl.NoteListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteListController {
    @Autowired
    private NoteListServiceImpl noteListServiceImpl;

    /*
    * 查询所有文章
    * */
    @GetMapping("/all")
    public CrResult selectAllNote() {
        CrArticle crArticles = noteListServiceImpl.selectByNoteId(1);
        String result = JSON.toJSONString(crArticles);
        return CrResult.success(result);
    }
}
