package com.jikaigg.blog.mapper;

import com.jikaigg.blog.domain.CrCategorie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 分类表(CrCategorie)表数据库访问层
 *
 * @author makejava
 * @since 2023-10-27 17:51:31
 */
@Mapper
public interface CrCategorieMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param categoryId 主键
     * @return 实例对象
     */
    CrCategorie queryById(Integer categoryId);

    /**
     * 查询指定行数据
     *
     * @param crCategorie 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CrCategorie> queryAllByLimit(CrCategorie crCategorie, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param crCategorie 查询条件
     * @return 总行数
     */
    long count(CrCategorie crCategorie);

    /**
     * 新增数据
     *
     * @param crCategorie 实例对象
     * @return 影响行数
     */
    int insert(CrCategorie crCategorie);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrCategorie> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CrCategorie> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CrCategorie> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CrCategorie> entities);

    /**
     * 修改数据
     *
     * @param crCategorie 实例对象
     * @return 影响行数
     */
    int update(CrCategorie crCategorie);

    /**
     * 通过主键删除数据
     *
     * @param categoryId 主键
     * @return 影响行数
     */
    int deleteById(Integer categoryId);

}

