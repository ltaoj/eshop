package org.eshop.service.impl;

import org.eshop.entity.Verifycode;
import org.eshop.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Service
public class EmailServiceimpl implements EmailService {

    private MailSender mailSender;

    @Autowired
    public EmailServiceimpl(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerifyCodeEmail(Verifycode verifycode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("注册验证码");
        message.setTo(verifycode.getEmail());
        message.setText("您的注册验证码为：" + verifycode.getCode());
        mailSender.send(message);
    }
}
