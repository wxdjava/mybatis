package org.god.ibatis.core;

import java.sql.Connection;

/**
 * 事务管理器接口
 * JDBC事务管理器，MANAGED事务管理器都应该实现这个接口
 * Transaction事务管理器：提供管理事务的方法
 * @author wangxuedeng
 * @date 2023/2/1 - 20:24
 */
public interface Transaction {

    void commit();
    void rollback();
    void close();
    void openConnection();
    Connection getConnection();
}
