package org.god.ibatis.core;

import java.lang.reflect.Method;
import java.sql.*;

/**
 * 专门负责执行SQL语句的会话对象
 * @author wangxuedeng
 * @date 2023/2/2 - 13:42
 */
public class SqlSession {

    private SqlSessionFactory factory;

    public SqlSession(SqlSessionFactory factory){
        this.factory = factory;
    }

    public int insert(String sqlId,Object pojo){
        int count = 0;
        try {
            Connection connection = factory.getTransaction().getConnection();
            String godbatisSql = factory.getMappedStatements().get(sqlId).getSql();
            String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            PreparedStatement ps = connection.prepareStatement(sql);
            //给？占位符传值
            int fromIndex = 0;
            int index = 1;
            while (true){
                int jingIndex = godbatisSql.indexOf("#",fromIndex);
                if (jingIndex < 0) {
                    break;
                }
                int youKuoHaoIndex = godbatisSql.indexOf("}",fromIndex);
                String propertyName = godbatisSql.substring(jingIndex + 2,youKuoHaoIndex).trim();
                fromIndex = youKuoHaoIndex + 1;

                String getMethodName = "get" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                Method getMethod = pojo.getClass().getDeclaredMethod(getMethodName);
                Object propertyValue = getMethod.invoke(pojo);
                ps.setString(index,propertyValue.toString());
                index++;
            }
            count = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 执行查询语句，返回一个对象
     * @param sqlId
     * @param param
     * @return
     */
    public Object selectOne(String sqlId,Object param){
        Object obj = null;
        try {
            Connection connection = factory.getTransaction().getConnection();
            MappedStatement mappedStatement = factory.getMappedStatements().get(sqlId);
            String godbatisSql = mappedStatement.getSql();
            String sql = godbatisSql.replaceAll("#\\{[a-zA-Z0-9_$]*}", "?");
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,param.toString());
            ResultSet rs = ps.executeQuery();
            String resultType = mappedStatement.getResultType();
            if (rs.next()) {
                Class<?> resultTypeClass = Class.forName(resultType);
                obj = resultTypeClass.newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 0; i < columnCount; i++) {
                    String propertyName = rsmd.getColumnName(i + 1);
                    String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                    Method setMethod = resultTypeClass.getDeclaredMethod(setMethodName, String.class);
                    setMethod.invoke(obj,rs.getString(propertyName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public void commit(){
        factory.getTransaction().commit();
    }

    public void rollback(){
        factory.getTransaction().rollback();
    }

    public void close(){
        factory.getTransaction().close();
    }
}
