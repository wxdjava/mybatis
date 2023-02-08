package com.wxd.crud.mapper;

import com.wxd.crud.pojo.Car;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/4 - 12:17
 */
public interface CarMapper {
    int insert(Car car);
    int deleteById(Long id);
    int update(Car car);
    Car selectById(Long id);
    List<Car> selectAll();
}
