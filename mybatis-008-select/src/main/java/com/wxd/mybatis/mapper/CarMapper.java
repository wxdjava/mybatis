package com.wxd.mybatis.mapper;

import com.wxd.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

/**
 * @author wangxuedeng
 * @date 2023/2/9 - 22:08
 */
public interface CarMapper {

    Map<String,Object> selectByIdRetMap(Long id);

    List<Map<String,Object>> selectAllRetMap();

    @MapKey("id")
    Map<Long,Map<String,Object>> selectAllRetBigMap();

    List<Car> selectAllByResultMap();

    List<Car> selectByMapUnderscoreToCamelCase();

    Long selectAllRetTotal();

}
