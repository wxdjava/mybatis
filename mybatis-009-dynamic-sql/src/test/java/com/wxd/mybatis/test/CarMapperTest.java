package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 11:04
 */
public class CarMapperTest {

    @Test
    public void testSelectTestIf(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectTestIf("红",1.0,"新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectTestWhere(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectTestWhere("",10.0,"");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectTestTrim(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectTestTrim("",10.0,"");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testUpdateTestSet(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(32L, null, "红旗", null, "2023-02-10", null);
        mapper.updateTestSet(car);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectTestChoose(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectTestChoose("",10.0,"null");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testDeleteTestForeach(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {4L,5L,6L};
        mapper.deleteTestForeach(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteTestForeach2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long[] ids = {7L,8L,9L};
        mapper.deleteTestForeach2(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertTestForeach(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = new ArrayList<>();
        Car car1 = new Car(null, "20", "兰博基尼1", 100.0, "2023-02-10", "燃油车");
        Car car2 = new Car(null, "21", "兰博基尼2", 100.0, "2023-02-10", "燃油车");
        Car car3 = new Car(null, "22", "兰博基尼3", 100.0, "2023-02-10", "燃油车");
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        mapper.insertTestForeach(cars);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectTestSqlAndInclude("新能源");
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }
}
