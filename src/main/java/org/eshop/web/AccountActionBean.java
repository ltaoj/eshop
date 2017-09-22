package org.eshop.web;

import org.eshop.domain.ErrorCode;
import org.eshop.domain.Register;
import org.eshop.domain.Result;
import org.eshop.entity.Userinfo;
import org.eshop.exception.AccountServiceException;
import org.eshop.exception.VerifycodeServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.AccountService;
import org.eshop.service.VerifycodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "account/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "用户名和密码错误，请重试");
        }
        if (logout != null) {
            model.addObject("msg", "您已成功退出");
        }
        model.setViewName("login");
        return model;
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/signin?logout";
    }

    @RequestMapping(value = "myInfo", method = RequestMethod.GET)
    public String showUserInfo(Model model) {
        try {
            Userinfo userInfo = accountService.getUser(getPrincipal());
            model.addAttribute("user", userInfo);
            return "account/userInfo";
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_USERINFO_FAILEED);
        }
    }
}
