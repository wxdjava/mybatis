package com.wxd.bank.dao.Impl;

import com.wxd.bank.dao.AccountDao;
import com.wxd.bank.pojo.Account;
import com.wxd.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 9:48
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public Account selectActno(String actno) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Account account = (Account) sqlSession.selectOne("account.selectByActno", actno);
        return account;
    }

    @Override
    public int updateActno(Account act) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.insert("account.updateByActno", act);
        return count;
    }
}
