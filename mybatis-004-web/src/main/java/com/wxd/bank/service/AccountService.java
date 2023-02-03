package com.wxd.bank.service;

import com.wxd.bank.exceptions.MoneyNotEnoughException;
import com.wxd.bank.exceptions.TransferException;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 9:10
 */
public interface AccountService {
    void transfer(String fromActno,String toActno,Double money) throws MoneyNotEnoughException, TransferException;
}
