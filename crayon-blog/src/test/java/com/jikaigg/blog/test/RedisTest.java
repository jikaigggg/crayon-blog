package com.jikaigg.blog.test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test1(){
        stringRedisTemplate.opsForValue().set("yyy","kkkkk",1, TimeUnit.MINUTES);
    }

    @Test
    public void test2(){
        ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
        String yaoyao = operations.get("yaoyao");
        System.out.println(yaoyao);
    }
}
