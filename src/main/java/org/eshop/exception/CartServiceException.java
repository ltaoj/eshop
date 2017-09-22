package org.eshop.exception;

/**
 * Created by ltaoj on 2017/9/23.
 */
public class CartServiceException extends ServiceException {
    public CartServiceException() {
    }

    public CartServiceException(String message) {
        super(message);
    }

    public CartServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartServiceException(Throwable cause) {
        super(cause);
    }

    public CartServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
