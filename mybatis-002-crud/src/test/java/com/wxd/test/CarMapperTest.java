package com.wxd.test;

import com.wxd.pojo.Car;
import com.wxd.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxuedeng
 * @date 2023/1/28 - 22:03
 */
public class CarMapperTest {
    @Test
    public void testInsertCar(){

        Map<String,Object> map = new HashMap<>();
        map.put("carNum","100");
        map.put("brand","大众");
        map.put("guidePrice",10.0);
        map.put("produceTime","2023-01-29");
        map.put("carType","新能源");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar", map);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPojo(){

        Car car = new Car(null, "100", "大众", 20.0, "2023-01-31", "燃油车");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("insertCar", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testDeleteById(){

        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 19);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testUpdateById(){

        Car car = new Car(3L, "222", "兰博基尼", 100.0, "2023-01-31", "燃油车");
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.update("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void testSelectById(){

        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById", 3);
        System.out.println(car);
        sqlSession.close();

    }

    @Test
    public void testSelectAll(){

        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();

    }

}
