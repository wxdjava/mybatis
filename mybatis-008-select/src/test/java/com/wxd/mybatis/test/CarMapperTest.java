package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.CarMapper;
import com.wxd.mybatis.pojo.Car;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

/**
 * @author wangxuedeng
 * @date 2023/2/9 - 22:10
 */
public class CarMapperTest {

    @Test
    public void testSelectByIdRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<String,Object> carMap = mapper.selectByIdRetMap(33L);
        System.out.println(carMap);
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Map<String,Object>> maps =  mapper.selectAllRetMap();
        maps.forEach(map -> {
            System.out.println(map);
        });
        sqlSession.close();
    }

    @Test
    public void selectAllRetBigMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Map<Long,Map<String,Object>> map = mapper.selectAllRetBigMap();
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testMapUnderscoreToCamelCase(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByMapUnderscoreToCamelCase();
        cars.forEach(car -> {
            System.out.println(car);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetTotal(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Long total = mapper.selectAllRetTotal();
        System.out.println(total);
        sqlSession.close();
    }
}
