package org.eshop.web;

import com.sun.org.apache.regexp.internal.RE;
import org.eshop.entity.Result;
import org.eshop.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Controller
public class AccountActionBean extends AbstractActionBean {

    private AccountService accountService;

    @Autowired
    public AccountActionBean(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(value = "registForm", method = RequestMethod.GET)
    public String showRegistForm() {
        return "account/register";
    }

//    @RequestMapping(value = "regist", method = RequestMethod.POST)
//    public ResponseEntity<Result> regist() {
//
//    }
}
