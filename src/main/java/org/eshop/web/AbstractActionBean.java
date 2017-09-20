package org.eshop.web;

import org.eshop.domain.Error;
import org.eshop.domain.ErrorCode;
import org.eshop.exception.WrapperServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
            case ErrorCode.SEND_EMAIL_CODE_ERROR:
                error = new Error(e.getErrorCode(), "验证码获取失败，请重试");
                break;
        }
        return error;
    }

    public String getPrincipal(){
        String userId=null;
        Object principal= SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            userId=((UserDetails) principal).getUsername();
        }else{
            userId=principal.toString();
        }
        return userId;
    }
}
