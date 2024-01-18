package com.jikaigg.blog.exception;

import com.jikaigg.blog.common.CrResult;
import jakarta.validation.ConstraintViolationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * validation参数校验注解异常拦截处理
     * @param e
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public CrResult handleException(ConstraintViolationException e) {
        e.printStackTrace();
        return CrResult.fail("000", "参数不合法！");
    }
}
