package org.eshop.web;

import org.eshop.entity.Error;
import org.eshop.exception.WrapperServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by ltaoj on 2017/9/11.
 */
public abstract class AbstractActionBean {
    @ExceptionHandler(WrapperServiceException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Error serviceError(WrapperServiceException e) {
        Error error = null;
        switch (e.getErrorCode()) {
            case 1:
                error = new Error(e.getErrorCode(), "验证码获取失败，请重试");
                break;
        }
        return error;
    }
}
