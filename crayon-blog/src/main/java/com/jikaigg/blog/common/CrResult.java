package com.jikaigg.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一返回
 *
 * @author jikaigg
 * @since 2023-10-27 17:51:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CrResult<T> {
    private String success;
    private String code;
    private String message;
    private T data;

    public static <T> CrResult<T> success(T data) {
        CrResult<T> crResult = new CrResult<>();
        crResult.setSuccess("success");
        crResult.setCode("00000000");
        crResult.setMessage("成功");
        crResult.setData(data);
        return crResult;
    }

    public static CrResult fail(String code, String message) {
        CrResult crResult = new CrResult();
        crResult.setSuccess("fail");
        crResult.setCode(code);
        crResult.setMessage(message);
        return crResult;
    }
}
