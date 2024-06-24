package com.jikaigg.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jikaigg.blog.mapper")
public class CrayonBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(CrayonBlogApplication.class, args);
    }
}
