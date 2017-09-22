package org.eshop.exception;

/**
 * Created by ltaoj on 2017/9/23.
 */
public class CatelogServiceException extends ServiceException {
    public CatelogServiceException() {
    }

    public CatelogServiceException(String message) {
        super(message);
    }

    public CatelogServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public CatelogServiceException(Throwable cause) {
        super(cause);
    }

    public CatelogServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
