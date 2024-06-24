package com.jikaigg.blog.controller;

import com.jikaigg.blog.common.CyResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public CyResult index() {
        logger.info("测试日志持久化开始了");
        return null;
    }
}
