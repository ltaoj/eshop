package org.eshop.web;

import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.entity.Verifycode;
import org.eshop.exception.VerifycodeServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.EmailService;
import org.eshop.service.VerifycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Controller
public class VerifycodeActionBean extends AbstractActionBean {

    private VerifycodeService verifycodeService;
    private EmailService emailService;

    @Autowired
    public VerifycodeActionBean(VerifycodeService verifycodeService, EmailService emailService) {
        this.verifycodeService = verifycodeService;
        this.emailService = emailService;
    }

    @RequestMapping(value = "emcode", method = RequestMethod.GET)
    public ResponseEntity<Result> sendVerifyCode(String email) {
        try {
            String code = verifycodeService.getRandomCode();
            Verifycode verifycode = new Verifycode();
            verifycode.setEmail(email);
            verifycode.setCode(code);
            verifycode.setExpireDate(new Timestamp(System.currentTimeMillis() + 10 * 60 * 1000));
            verifycodeService.insertVerifyCode(verifycode); // 将验证码记录插入数据库
            emailService.sendVerifyCodeEmail(verifycode);// 发送邮件验证码
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "发送成功,请再10分钟输入验证码"), HttpStatus.OK);
        } catch (VerifycodeServiceException e) {
            throw new WrapperServiceException(e, ErrorCode.SEND_EMAIL_CODE_ERROR);
        }
    }
}
