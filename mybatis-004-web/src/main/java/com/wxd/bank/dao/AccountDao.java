package com.wxd.bank.dao;

import com.wxd.bank.pojo.Account;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 9:43
 */
public interface AccountDao {
    Account selectActno(String actno);
    int updateActno(Account act);
}
