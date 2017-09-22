package org.eshop.exception;

import org.eshop.web.AbstractActionBean;

/**
 * Created by ltaoj on 2017/9/23.
 */
public class OrderServiceException extends ServiceException {
    public OrderServiceException() {
    }

    public OrderServiceException(String message) {
        super(message);
    }

    public OrderServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderServiceException(Throwable cause) {
        super(cause);
    }

    public OrderServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
