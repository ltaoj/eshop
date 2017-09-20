package org.eshop.exception;

/**
 * Created by ltaoj on 2017/9/20.
 */
public class WrapperServiceException extends RuntimeException{
    private ServiceException serviceException;
    private int errorCode;

    public WrapperServiceException(ServiceException serviceException, int errorCode) {
        this.serviceException = serviceException;
        this.errorCode = errorCode;
    }

    public WrapperServiceException(String message, ServiceException serviceException) {
        super(message);
        this.serviceException = serviceException;
    }

    public WrapperServiceException(String message, Throwable cause, ServiceException serviceException) {
        super(message, cause);
        this.serviceException = serviceException;
    }

    public WrapperServiceException(Throwable cause, ServiceException serviceException) {
        super(cause);
        this.serviceException = serviceException;
    }

    public WrapperServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ServiceException serviceException) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.serviceException = serviceException;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
}
