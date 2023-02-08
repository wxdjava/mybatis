package com.wxd.mybatis;

import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/5 - 11:18
 */
public class CarMapperTest {
    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectByTime(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByTime("desc");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testDeleteByBrand(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteByBrand("QQ");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteById("26,27");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testselectByLikeBrand(){
        /*
        *'%${brand}%'
        *concat('%',#{brand},'%')
        * "%"#{brand}"%"
        */
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByLikeBrand("宝马");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testInsertCarUseGenerateKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
    }
}
