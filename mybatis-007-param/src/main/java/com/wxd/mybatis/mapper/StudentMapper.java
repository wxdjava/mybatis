package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wangxuedeng
 * @date 2023/2/9 - 13:29
 */
public interface StudentMapper {

    List<Student> selectByDate(Date date);
    List<Student> selectBySex(Character sex);
    int insertStudentByMap(Map<String,Object> map);
    List<Student> selectByNameAndSex(String name,Character sex);
    /**
     * 使用param注解
     * mybatis底层框架实现原理：
     * map.put("name",name)
     * map.put("sex",sex)
     * @param name
     * @param sex
     * @return
     */
    List<Student> selectByNameAndSexParam(@Param("name") String name,@Param("sex") Character sex);

}
