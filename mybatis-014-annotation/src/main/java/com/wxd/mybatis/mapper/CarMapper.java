package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Car;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 10:57
 */
public interface CarMapper {

    @Insert("insert into t_car values(null,#{carNum},#{brand},#{guidePrice},#{produceTime},#{carType})")
    int insertByCar(Car car);

    @Delete("delete from t_car where id = #{id}")
    int deleteById(Long id);

    @Update("update t_car set car_num = #{carNum},brand = #{brand},guide_price = #{guidePrice},produce_time = #{produceTime},car_type = #{carType} where id = #{id}")
    int updateById(Car car);

    @Select("select * from t_car where id = #{id}")
    Car selectById(Long id);

    @Select("select * from t_car")
    @Results({
            @Result(column = "id",id = true,property = "id"),
            @Result(column = "car_num",property = "carNum"),
            @Result(column = "brand",property = "brand"),
            @Result(column = "guide_price",property = "guidePrice"),
            @Result(column = "produce_time",property = "produceTime"),
            @Result(column = "car_type",property = "carType"),
    })
    List<Car> selectAllByResult();

}
