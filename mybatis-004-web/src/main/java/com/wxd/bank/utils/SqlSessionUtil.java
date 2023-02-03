package com.wxd.bank.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * @author wangxuedeng
 * @date 2023/1/28 - 21:02
 */
public class SqlSessionUtil {

    /**
     * 1.工具类的构造方法一般都是私有化的
     * 2.工具类中所有方法都是静态的，直接采用类名调用
     * 3.为了防止调用，构造方法私有化
     */
    private SqlSessionUtil(){

    }

    private static SqlSessionFactory sqlSessionFactory;
    //全局的，一个服务器中定义一个
    //一个线程一个sqlsession对象
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    //SqlSessionUtil工具类在进行第一次加载的时候，解析mybatis-config.xml文件，创建SqlSessionFactory对象
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取会话对象
     * @return 会话对象
     */
    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            //将SQLSession绑定到当前线程
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession) {
        if (sqlSession != null) {
            sqlSession.close();
            //移除sqlsession对象和当前线程的绑定关系
            local.remove();
        }
    }
}
