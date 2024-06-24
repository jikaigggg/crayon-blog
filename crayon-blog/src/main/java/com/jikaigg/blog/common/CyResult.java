package com.jikaigg.blog.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CyResult<T> {
    /**
     * 响应状态
     * success|timeout|fail
     */
    private String success;
    /**
     * 响应编码
     */
    private String code;
    private String message;

    /**
     * 响应结果数据
     */
    private T data;

}
