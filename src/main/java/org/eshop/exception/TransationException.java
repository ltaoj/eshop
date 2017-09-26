package org.eshop.exception;

import org.eshop.entity.Item;

/**
 * Created by ltaoj on 2017/8/13.
 */
public class TransationException extends ServiceException{
    private Item withdrawInst;

    public Item getWithdrawInst() {
        return withdrawInst;
    }

    public void setWithdrawInst(Item withdrawInst) {
        this.withdrawInst = withdrawInst;
    }

    public TransationException(Item withdrawInst) {
        this.withdrawInst = withdrawInst;
    }

    public TransationException() {
    }

    public TransationException(String message) {
        super(message);
    }

    public TransationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TransationException(Throwable cause) {
        super(cause);
    }

    public TransationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
