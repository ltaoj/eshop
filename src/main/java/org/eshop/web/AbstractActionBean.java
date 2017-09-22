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
            case ErrorCode.EMAIL_CODE_INVALID:
                error = new Error(e.getErrorCode(), "验证码输入错误");
                break;
            case ErrorCode.REGIST_FAILED_ERROR:
                error = new Error(e.getErrorCode(), "注册失败");
                break;
            case ErrorCode.GET_USERINFO_FAILEED:
                error = new Error(e.getErrorCode(), "用户信息查询失败");
                break;
            case ErrorCode.ADD_ADDRESS_FAILED:
                error = new Error(e.getErrorCode(), "收获地址添加失败");
                break;
            case ErrorCode.DEL_ADDRESS_FAILED:
                error = new Error(e.getErrorCode(), "收获地址删除失败");
                break;
            case ErrorCode.GET_ADDRESS_FAILED:
                error = new Error(e.getErrorCode(), "收货地址信息获取失败");
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
