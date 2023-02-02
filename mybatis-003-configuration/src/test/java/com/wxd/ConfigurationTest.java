package com.wxd;

import com.wxd.pojo.Car;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;

/**
 * @author wangxuedeng
 * @date 2023/2/1 - 10:28
 */
public class ConfigurationTest {
    @Test
    public void testEnvironment() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Car car = new Car(null, "100", "QQ", 20.0, "2023-02-01", "燃油车");
        int count = sqlSession.insert("insertCar",car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();

        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"), "bjpowernode");
        SqlSession sqlSession1 = sqlSessionFactory1.openSession();
        Car car1 = new Car(18L, "100", "QQ", 20.0, "2023-02-01", "燃油车");
        int count1 = sqlSession1.update("updateById", car1);
        System.out.println(count1);
        sqlSession1.commit();
        sqlSession1.close();
    }
}
