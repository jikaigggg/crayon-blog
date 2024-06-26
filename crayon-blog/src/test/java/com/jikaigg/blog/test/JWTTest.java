package com.jikaigg.blog.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jikaigg.blog.utils.Md5Util;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    /**
     * 生成jwt
     */
    @Test
    public void test() {
        Map<String, Object> clainms = new HashMap<>();
        clainms.put("name", "zhangsan");
        String sign = JWT.create()
                .withClaim("user", clainms)  // 添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12))   // 添加过期时间
                .sign(Algorithm.HMAC256("jikaigggg"));// 指定算法，加密秘钥
        System.out.println(sign);
    }

    /**
     * 验证jwt
     */
    @Test
    public void test2() {
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjbGFpbXMiOnsiaWQiOm51bGwsInVzZXJuYW1lIjoieWFvamlrYWkifSwiZXhwIjoxNzA2MDIxMzQ2fQ.DbKtPJB38xxbx-njc20pmcyLqtHaLwI8Et4lZ9ev0Dk";
        JWTVerifier jikaigggg = JWT.require(Algorithm.HMAC256("jikaigggg")).build();
        DecodedJWT verify = jikaigggg.verify(jwt);
        Map<String, Claim> claims = verify.getClaims();
        System.out.println(claims.get("id"));

    }

    @Test
    public void test3(){
        String md5String = Md5Util.getMD5String("testtest");
        System.out.println(md5String);
    }

}
