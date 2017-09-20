package org.eshop.service;

import org.eshop.entity.Verifycode;
import org.eshop.exception.VerifycodeServiceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface VerifycodeService {

    /**
     * 随机生成6为数字+字母验证码
     * @return
     * @throws VerifycodeServiceException
     */
    String getRandomCode() throws VerifycodeServiceException;

    /**
     * 将验证码添加到数据库
     * @param verifycode
     * @throws VerifycodeServiceException
     */
    void insertVerifyCode(Verifycode verifycode) throws VerifycodeServiceException;

    /**
     * 返回获取验证码记录
     * @param email
     * @throws VerifycodeServiceException
     */
    Verifycode getVerifycode(String email) throws VerifycodeServiceException;
}
