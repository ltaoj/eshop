package org.eshop.service;

import org.eshop.entity.Verifycode;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface EmailService {
    /**
     * 发送验证码邮件
     * @param verifycode
     */
    void sendVerifyCodeEmail(Verifycode verifycode);
}
