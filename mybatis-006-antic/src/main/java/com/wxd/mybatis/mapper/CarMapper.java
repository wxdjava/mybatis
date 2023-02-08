package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Car;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/4 - 12:17
 */
public interface CarMapper {
    List<Car> selectByCarType(String carType);
    List<Car> selectByTime(String ascORDesc);
    int deleteByBrand(String brand);
    int deleteById(String id);
    List<Car> selectByLikeBrand(String brand);
}
