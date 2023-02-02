package org.god.ibatis.core;

/**
 * 封装一个SQL标签
 * 一个mappedstatement对象对应一个SQL标签
 * @author wangxuedeng
 * @date 2023/2/1 - 20:08
 */
public class MappedStatement {

    private String sql;
    private String resultType;

    public MappedStatement() {
    }

    public MappedStatement(String sql, String resultType) {
        this.sql = sql;
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "MappedStatement{" +
                "sql='" + sql + '\'' +
                ", resultType='" + resultType + '\'' +
                '}';
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
