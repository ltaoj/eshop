package org.eshop.web;

import org.eshop.domain.Error;
import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.exception.HandleFileUploadException;
import org.eshop.exception.HandleTransationException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.util.ConfigUtil;
import org.eshop.util.IOUtil;
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
            case ErrorCode.UPDATE_ADDRESS_FAILED:
                error = new Error(e.getErrorCode(), "收货地址信息更新失败");
                break;
            case ErrorCode.DEFAULT_ADDRESS_SETTING_FAILED:
                error = new Error(e.getErrorCode(), "默认收货地址修改失败");
                break;
            case ErrorCode.ORIGIN_PASSWORD_UNCORRECT:
                error = new Error(e.getErrorCode(), "原密码不正确");
                break;
            case ErrorCode.CHANGE_PASSWORD_FAILED:
                error = new Error(e.getErrorCode(), "修改密码失败");
            case ErrorCode.UPDATE_USERINFO_FAILED:
                error = new Error(e.getErrorCode(), "基本信息修改失败");
                break;
        }
        return error;
    }

    @ExceptionHandler(HandleFileUploadException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Result fileUploadError(HandleFileUploadException e) {
        return new Result(Result.RESULT_ERROR, e);
    }

    @ExceptionHandler(HandleTransationException.class)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody Result transationError(HandleTransationException e) {
        String path = ConfigUtil.getPath();
        path = path.substring(0, path.lastIndexOf(System.getProperty("file.separator")));
        IOUtil.removeFile(path, e.getTransationException().getWithdrawInst().getDescription());
        return new Result(Result.RESULT_ERROR, e);
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
