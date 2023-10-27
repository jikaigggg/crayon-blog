package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.CrComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 评论表(CrComment)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-27 17:51:41
 */
@Mapper
public interface CrCommentMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param commentId 主键
     * @return 实例对象
     */
    CrComment queryById(Integer commentId);

    /**
     * 查询指定行数据
     *
     * @param crComment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CrComment> queryAllByLimit(CrComment crComment, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param crComment 查询条件
     * @return 总行数
     */
    long count(CrComment crComment);

    /**
     * 新增数据
     *
     * @param crComment 实例对象
     * @return 影响行数
     */
    int insert(CrComment crComment);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrComment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CrComment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrComment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CrComment> entities);

    /**
     * 修改数据
     *
     * @param crComment 实例对象
     * @return 影响行数
     */
    int update(CrComment crComment);

    /**
     * 通过主键删除数据
     *
     * @param commentId 主键
     * @return 影响行数
     */
    int deleteById(Integer commentId);

}

