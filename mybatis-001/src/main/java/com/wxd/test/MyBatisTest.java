package com.wxd.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wangxuedeng
 * @date 2023/1/26 - 17:17
 */
public class MyBatisTest {
    public static void main(String[] args) throws IOException {
        //1.获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //2.获取SqlSessionFactory对象
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        //3.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4.执行SQL语句
        int count = sqlSession.insert("insertCar");
        System.out.println("插入了" + count + "条记录！");

        //5.手动提交
        sqlSession.commit();
    }
}
