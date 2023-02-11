package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 10:57
 */
public interface CarMapper {

    List<Car> selectTestIf(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    List<Car> selectTestWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    List<Car> selectTestTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    int updateTestSet(Car car);

    List<Car> selectTestChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    int deleteTestForeach(@Param("ids") Long[] ids);

    int deleteTestForeach2(@Param("ids") Long[] ids);

    int insertTestForeach(@Param("cars") List<Car> cars);

    List<Car> selectTestSqlAndInclude(String carType);
}
