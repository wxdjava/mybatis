package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Student;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 21:00
 */
public interface StudentMapper {

    Student selectById(Integer id);

    Student selectByIdWithAssociate(Integer id);

    Student selectByIdWithStep(Integer id);

    Student selectByClazzWithStep(Integer id);
}
