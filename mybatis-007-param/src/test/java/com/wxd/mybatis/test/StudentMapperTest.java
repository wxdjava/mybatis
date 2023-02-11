package com.wxd.mybatis.test;

import com.wxd.mybatis.mapper.StudentMapper;
import com.wxd.mybatis.pojo.Student;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/9 - 13:30
 */
public class StudentMapperTest {

    @Test
    public void testSelectByDate() throws Exception{
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = (Date) dateFormat.parse("2022-09-01");
        List<Student> students = mapper.selectByDate(birth);
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }

    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","王五");
        map.put("age",23);
        map.put("height",1.66);
        map.put("sex",'男');
        map.put("birth",new Date());
        mapper.insertStudentByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("赵六",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSexParam(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("赵六",'男');
        students.forEach(student -> {
            System.out.println(student);
        });
        sqlSession.close();
    }
}
