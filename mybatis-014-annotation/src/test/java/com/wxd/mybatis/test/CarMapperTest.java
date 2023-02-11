package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/11 - 20:56
 */
public class CarMapperTest {

    @Test
    public void testInsertByCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null, "666", "霸道", 50.0, "2023-02-11", "新能源");
        mapper.insertByCar(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        mapper.deleteById(11L);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(12L, "666", "霸道", 50.0, "2023-02-11", "新能源");
        mapper.updateById(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(39L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByResult(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResult();
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

}
