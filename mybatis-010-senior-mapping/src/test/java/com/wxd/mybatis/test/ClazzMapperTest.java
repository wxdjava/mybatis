package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.ClazzMapper;
import com.wxd.mybatis.pojo.Clazz;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 21:08
 */
public class ClazzMapperTest {

    @Test
    public void testClazzResultMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByIdWithCollection(2001);
        System.out.println(clazz);
        sqlSession.close();
    }

    @Test
    public void testSelectByIdWithStep(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByIdWithStep(2001);
        //System.out.println(clazz);
        System.out.println(clazz.getCname());
        sqlSession.close();
    }

}
