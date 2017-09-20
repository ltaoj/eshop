package org.eshop.web;

import org.eshop.domain.ErrorCode;
import org.eshop.domain.Register;
import org.eshop.domain.Result;
import org.eshop.exception.AccountServiceException;
import org.eshop.exception.VerifycodeServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.AccountService;
import org.eshop.service.VerifycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Controller
public class AccountActionBean extends AbstractActionBean {

    private AccountService accountService;
    private VerifycodeService verifycodeService;

    @Autowired
    public AccountActionBean(AccountService accountService, VerifycodeService verifycodeService) {
        this.accountService = accountService;
        this.verifycodeService = verifycodeService;
    }

    @RequestMapping(value = "registForm", method = RequestMethod.GET)
    public String showRegistForm() {
        return "account/register";
    }

    @RequestMapping(value = "regist", method = RequestMethod.POST)
    public ResponseEntity<Result> regist(@RequestBody Register register) {
        try {
            // 验证邮箱和验证码是否正确匹配
            if (!verifycodeService.isVerifycodeValid(register.getSignon().getEmail(), register.getCode())) {
                throw new WrapperServiceException(ErrorCode.EMAIL_CODE_INVALID);
            }
            accountService.registUser(register.getSignon());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "注册成功"), HttpStatus.OK);
        } catch (VerifycodeServiceException e) {
            throw new WrapperServiceException(e, ErrorCode.EMAIL_CODE_INVALID);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(e, ErrorCode.REGIST_FAILED_ERROR);
        }
    }
}
