package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 10:57
 */
public interface CarMapper {

    List<Car> selectByPage(@Param("startIndex") Integer startIndex,@Param("pageSize") Integer pageSize);

    List<Car> selectAll();

}
