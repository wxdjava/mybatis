package com.wxd.bank.dao;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 17:19
 */
public interface AccountDao {
    void delete();
    int insert(String actno);
    int update(String actno,Double balance);
    String selectByActno(String actno);
}
