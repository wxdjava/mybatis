package org.god.ibatis.core;

import java.sql.Connection;

/**
 * MANAGED事务管理器
 * @author wangxuedeng
 * @date 2023/2/1 - 20:36
 */
public class ManagedTransaction implements Transaction{
    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() {

    }

    @Override
    public void openConnection() {

    }

    @Override
    public Connection getConnection() {
        return null;
    }
}
