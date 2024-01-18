package com.jikaigg.blog.test;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {

    /**
     * 生成jwt
     */
    @Test
    public void test(){
        Map<String,Object> clainms = new HashMap<>();
        clainms.put("name","zhangsan");
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
    public void test2(){
        String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDU2MTAxNTQsInVzZXIiOnsibmFtZSI6InpoYW5nc2FuIn19.Ugj5lhABmGfHg21pOKPW3-GA7v7kuoYon5gU1CuMd94";
        JWTVerifier jikaigggg = JWT.require(Algorithm.HMAC256("jikaigggg")).build();
        DecodedJWT verify = jikaigggg.verify(jwt);
        Map<String, Claim> claims = verify.getClaims();
        System.out.println(claims.get("user"));

    }

}
