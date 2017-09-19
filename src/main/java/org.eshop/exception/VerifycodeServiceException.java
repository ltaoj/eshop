package org.eshop.exception;

/**
 * Created by ltaoj on 2017/9/18.
 */
public class VerifycodeServiceException extends ServiceException {

    public VerifycodeServiceException() {
    }

    public VerifycodeServiceException(String message) {
        super(message);
    }

    public VerifycodeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public VerifycodeServiceException(Throwable cause) {
        super(cause);
    }

    public VerifycodeServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
