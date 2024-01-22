package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 文章操作
 */
@RestController
@RequestMapping("article")
public class ArticleController {
    /**
     * 获取所有文章数据
     * @return
     */
    @PostMapping("list")
    public CrResult<String> list() {

        return CrResult.success("所有文章数据");
    }
}
