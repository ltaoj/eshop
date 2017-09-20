package org.eshop.service;

import org.eshop.entity.Verifycode;
import org.eshop.exception.VerifycodeServiceException;

/**
 * Created by ltaoj on 2017/9/18.
 */
public interface VerifycodeService {

    /**
     * 随机生成6位数字+字母验证码
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
     * 判断验证码是否正确
     * @param email
     * @param code
     * @throws VerifycodeServiceException
     */
    boolean isVerifycodeValid(String email, String code) throws VerifycodeServiceException;
}
