package com.wxd.crud.test;

import com.wxd.crud.mapper.CarMapper;
import com.wxd.crud.pojo.Car;
import com.wxd.crud.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/4 - 12:58
 */
public class CarMapperTest {
    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "10000", "长安", 100.0, "203-02-04", "燃油车");
        int count = mapper.insert(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById(28L);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(27L, "10000", "红旗", 100.0, "203-02-04", "燃油车");
        int count = mapper.update(car);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(27L);
        System.out.println(car);
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> {
            System.out.println(car);
        });
    }
}
