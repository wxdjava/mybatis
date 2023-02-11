package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.StudentMapper;
import com.wxd.mybatis.pojo.Student;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author wangxuedeng
 * @date 2023/2/10 - 21:08
 */
public class StudentMapperTest {

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectByIdWithAssociate(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdWithAssociate(4);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectByIdWithStep(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdWithStep(4);
        /*System.out.println(student);*/
        System.out.println(student.getSid());
        sqlSession.close();
    }
}
