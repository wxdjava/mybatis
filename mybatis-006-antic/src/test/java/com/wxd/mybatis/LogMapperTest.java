package com.wxd.mybatis;

import com.wxd.mybatis.mapper.LogMapper;
import com.wxd.mybatis.pojo.Log;
import com.wxd.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author wangxuedeng
 * @date 2023/2/5 - 11:55
 */
public class LogMapperTest {
    @Test
    public void testSelectByTime(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
        List<Log> logs = mapper.selectByTime("20230206");
        logs.forEach(log -> {
            System.out.println(log);
        });
        sqlSession.close();
    }
}
