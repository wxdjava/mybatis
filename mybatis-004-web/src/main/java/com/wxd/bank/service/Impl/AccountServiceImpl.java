package com.wxd.bank.service.Impl;

import com.wxd.bank.dao.AccountDao;
import com.wxd.bank.dao.Impl.AccountDaoImpl;
import com.wxd.bank.exceptions.MoneyNotEnoughException;
import com.wxd.bank.exceptions.TransferException;
import com.wxd.bank.pojo.Account;
import com.wxd.bank.service.AccountService;
import com.wxd.bank.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 9:40
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void transfer(String fromActno, String toActno, Double money) throws MoneyNotEnoughException, TransferException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        //1.判断转出账户余额是否充足
        Account fromAct = accountDao.selectActno(fromActno);
        Account toAct = accountDao.selectActno(toActno);
        if (fromAct.getBalance() < money) {
            //2.转出账户余额不足做出提示
            throw new MoneyNotEnoughException("对不起！账户余额不足！");
        }
        //3.转出账户余额充足，更新账户余额
        fromAct.setBalance(fromAct.getBalance() - money);
        //4.更新转入账户余额
        toAct.setBalance(toAct.getBalance() + money);
        int count = accountDao.updateActno(fromAct);
        count += accountDao.updateActno(toAct);

        if (count != 2) {
            throw new TransferException("对不起！转账失败！");
        }
        sqlSession.commit();
        SqlSessionUtil.close(sqlSession);
    }
}
