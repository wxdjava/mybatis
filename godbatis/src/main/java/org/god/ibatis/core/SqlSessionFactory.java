package org.god.ibatis.core;

import java.util.Map;

/**
 * SqlSessionFactory对象
 * 通过SqlSessionFactory对象可以获取SqlSession对象，开启会话
 * 一个SqlSessionFactory对象可以开启多个SqlSession会话
 * @author wangxuedeng
 * @date 2023/2/1 - 19:03
 */
public class SqlSessionFactory {

    /**
     * 事务管理器属性
     */
    private Transaction transaction;

    /**
     * 存放SQL语句的map集合
     * key是sqlId
     * value是对应的SQL标签信息对象
     */
    private Map<String,MappedStatement> mappedStatements;

    public SqlSessionFactory() {
    }

    public SqlSessionFactory(Transaction transaction, Map<String, MappedStatement> mappedStatements) {
        this.transaction = transaction;
        this.mappedStatements = mappedStatements;
    }

    /**
     * 获取SQL会话对象
     * @return
     */
    public SqlSession openSession(){
        transaction.openConnection();
        //创建SQL对象
        SqlSession sqlSession = new SqlSession(this);
        return sqlSession;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Map<String, MappedStatement> getMappedStatements() {
        return mappedStatements;
    }

    public void setMappedStatements(Map<String, MappedStatement> mappedStatements) {
        this.mappedStatements = mappedStatements;
    }
}
