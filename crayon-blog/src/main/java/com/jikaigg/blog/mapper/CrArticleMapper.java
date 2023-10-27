package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.CrArticle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 文章表(CrArticle)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-27 17:50:02
 */
@Mapper
public interface CrArticleMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param articleId 主键
     * @return 实例对象
     */
    CrArticle queryById(Integer articleId);

    /**
     * 查询指定行数据
     *
     * @param crArticle 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CrArticle> queryAllByLimit(CrArticle crArticle, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param crArticle 查询条件
     * @return 总行数
     */
    long count(CrArticle crArticle);

    /**
     * 新增数据
     *
     * @param crArticle 实例对象
     * @return 影响行数
     */
    int insert(CrArticle crArticle);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrArticle> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CrArticle> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrArticle> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CrArticle> entities);

    /**
     * 修改数据
     *
     * @param crArticle 实例对象
     * @return 影响行数
     */
    int update(CrArticle crArticle);

    /**
     * 通过主键删除数据
     *
     * @param articleId 主键
     * @return 影响行数
     */
    int deleteById(Integer articleId);

}

