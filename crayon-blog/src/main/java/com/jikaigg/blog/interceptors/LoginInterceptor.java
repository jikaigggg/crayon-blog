package com.jikaigg.blog.interceptors;

import com.jikaigg.blog.common.CrResult;
import com.jikaigg.blog.utils.JwtUtil;
import com.jikaigg.blog.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 拦截器解析验证token
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            String token = request.getHeader("Authorization");
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 存入ThreadLocal，供线程后续操作使用token
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e) {
            // 拦截
            response.setStatus(401);
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 操作完成后移除ThreadLocal，避免内存泄露
        ThreadLocalUtil.remove();
    }
}
