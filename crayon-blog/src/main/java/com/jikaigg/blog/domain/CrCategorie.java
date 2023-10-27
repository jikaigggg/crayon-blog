package com.jikaigg.blog.domain;

import java.io.Serializable;

/**
 * 分类表(CrCategorie)实体类
 *
 * @author makejava
 * @since 2023-10-27 17:51:31
 */
public class CrCategorie implements Serializable {
    private static final long serialVersionUID = -31492606144425004L;
    /**
     * 类别id
     */
    private Integer categoryId;
    /**
     * 类别名称
     */
    private String categoryName;


    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}

