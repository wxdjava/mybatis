package com.wxd.bank.exceptions;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 10:30
 */
public class MoneyNotEnoughException extends Exception{
    public MoneyNotEnoughException() {
    }
    public MoneyNotEnoughException(String msg){
        super(msg);
    }
}
