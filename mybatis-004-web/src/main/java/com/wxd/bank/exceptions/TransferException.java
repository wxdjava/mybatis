package com.wxd.bank.exceptions;

/**
 * @author wangxuedeng
 * @date 2023/2/3 - 10:38
 */
public class TransferException extends Exception{
    public TransferException() {
    }

    public TransferException(String message) {
        super(message);
    }
}
