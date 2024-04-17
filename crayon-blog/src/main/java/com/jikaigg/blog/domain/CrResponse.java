package com.jikaigg.blog.domain;

import lombok.Data;

import java.util.List;

/**
 * 分页信息通用Page
 * @param <T>
 */
@Data
public class CrResponse<T> {
    private Long total;
    private List<T> items;
}
