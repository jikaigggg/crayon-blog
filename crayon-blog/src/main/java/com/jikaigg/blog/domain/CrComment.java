package com.jikaigg.blog.domain;

import java.util.Date;
import java.io.Serializable;

/**
 * 评论表(CrComment)实体类
 *
 * @author makejava
 * @since 2023-10-27 17:51:42
 */
public class CrComment implements Serializable {
    private static final long serialVersionUID = 415847294263341170L;
    /**
     * 评论id
     */
    private Integer commentId;
    /**
     * 文章id
     */
    private Integer articleId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 父级评论的评论id
     */
    private Integer parentCommentId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date commentDate;


    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Integer parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

}

