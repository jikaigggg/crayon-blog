package com.jikaigg.blog.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Category {
    private Integer id;//主键ID
    @NotBlank
    private String categoryName;//分类名称
    @NotBlank
    private String categoryAlias;//分类别名
    private Integer createUser;//创建人ID
    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间
}
