package com.jikaigg.blog.config;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * mybatis-generator使用，生成mapper.xml时将text类型转换成String类型
 *
 * @author : jikaigg
 * @Date : 2023/10/27
 */
public class TestToStringResolver extends JavaTypeResolverDefaultImpl {
    @Override
    public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
        FullyQualifiedJavaType answer = null;
        JdbcTypeInformation jdbcTypeInformation = null;
        if (introspectedColumn.getJdbcType() == -1) {
            introspectedColumn.setJdbcType(12);
            jdbcTypeInformation = typeMap.get(12);
        } else {
            jdbcTypeInformation = typeMap.get(introspectedColumn.getJdbcType());
        }
        if (jdbcTypeInformation != null) {
            answer = jdbcTypeInformation.getFullyQualifiedJavaType();
            answer = overrideDefaultType(introspectedColumn, answer);
        }
        return answer;
    }
}
