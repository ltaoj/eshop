package org.eshop.web;

import org.eshop.domain.ChangePassword;
import org.eshop.domain.ErrorCode;
import org.eshop.domain.Register;
import org.eshop.domain.Result;
import org.eshop.entity.Harvestaddr;
import org.eshop.entity.Signon;
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

import javax.persistence.PersistenceException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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
            List<Harvestaddr> addrList = accountService.getHarvestAddr(getPrincipal());
            model.addAttribute("addrList", addrList);
            return "account/userInfo";
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_USERINFO_FAILEED);
        }
    }

    @RequestMapping(value = "upMyInfo", method = RequestMethod.POST)
    public ResponseEntity<Result> updateUserInfo(@RequestBody Userinfo userinfo) {
        try {
            userinfo.setLoginId(getPrincipal());
            accountService.updateUserInfo(userinfo);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "用户基本信息修改成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.UPDATE_USERINFO_FAILED);
        }
    }

    @RequestMapping(value = "isExist", method = RequestMethod.GET)
    public ResponseEntity<Result> isUserExist() {
        try {
            Userinfo userinfo = accountService.getUser(getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, userinfo != null), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_USERINFO_FAILEED);
        }
    }

    @RequestMapping(value = "addressModal", method = RequestMethod.GET)
    public String showAddrModal() {
        return "account/addAddress";
    }

    @RequestMapping(value = "addHarvAddr", method = RequestMethod.POST)
    public ResponseEntity<Result> addHarvestAddress(@RequestBody Harvestaddr harvestaddr) {
        try {
            harvestaddr.setLoginId(getPrincipal());
            accountService.addHarvestAddr(harvestaddr);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "收获地址添加成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.ADD_ADDRESS_FAILED);
        }
    }

    @RequestMapping(value = "delHarvAddr", method = RequestMethod.POST)
    public ResponseEntity<Result> deleteAddress(@RequestParam(value = "addrId" , required = true) int addrId) {
        try {
            accountService.deleteHarvestAddr(addrId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "收货地址删除成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.DEL_ADDRESS_FAILED);
        }
    }

    @RequestMapping(value = "addrList", method = RequestMethod.POST)
    public ResponseEntity<Result> getAddrList() {
        try {
            List<Harvestaddr> harvList = accountService.getHarvestAddr(getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, harvList), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_ADDRESS_FAILED);
        }
    }

    @RequestMapping(value = "upHarvAddr", method = RequestMethod.POST)
    public ResponseEntity<Result> updateAddress(@RequestBody Harvestaddr harvestaddr) {
        try {
            accountService.updateHarvestAddr(harvestaddr);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "收货地址信息修改成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.UPDATE_ADDRESS_FAILED);
        }
    }

    @RequestMapping(value = "setDefAddr", method = RequestMethod.POST)
    public ResponseEntity<Result> setDefaultAddress(
            @RequestParam(value = "addrId", required = true) int addrId,
            @RequestParam(value = "loginId", required = true) String loginId) {
        try {
            accountService.setDefaultAddr(addrId, loginId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "默认收货地址设置成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.DEFAULT_ADDRESS_SETTING_FAILED);
        }
    }

    @RequestMapping(value = "changePwd", method = RequestMethod.POST)
    public ResponseEntity<Result> changePassword(@RequestBody ChangePassword changePassword) {
        try {
            Signon signon = accountService.getSignon(getPrincipal());
            if (!signon.getPassword().equals(changePassword.getOriginPassword())){
                throw new WrapperServiceException(ErrorCode.ORIGIN_PASSWORD_UNCORRECT);
            }
            accountService.changePassword(getPrincipal(), changePassword.getPassword());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "密码修改成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.CHANGE_PASSWORD_FAILED);
        }
    }
}