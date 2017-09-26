package org.eshop.web;

import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.entity.Supplier;
import org.eshop.exception.AccountServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.AccountService;
import org.eshop.service.CatelogService;
import org.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/25.
 */
@Controller
public class AdminActionBean {

    private AccountService accountService;
    private CatelogService catelogService;
    private OrderService orderService;

    @Autowired
    public AdminActionBean(AccountService accountService, CatelogService catelogService, OrderService orderService) {
        this.accountService = accountService;
        this.catelogService = catelogService;
        this.orderService = orderService;
    }

    @RequestMapping(value = "catelogMg", method = RequestMethod.GET)
    public String showProduct() {
        return "admin/product";
    }

    @RequestMapping(value = "itemMg", method = RequestMethod.GET)
    public String showItem() {
        return "admin/item";
    }

    @RequestMapping(value = "orderMg", method = RequestMethod.GET)
    public String showOrder() {
        return "admin/order";
    }

    @RequestMapping(value = "spplierMg", method = RequestMethod.GET)
    public String showSupplier(Model model) {
        try {
            model.addAttribute("supplierList", accountService.getSupplierList());
            return "admin/supplier";
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_USERINFO_FAILEED);
        }
    }

    @RequestMapping(value = "registS", method = RequestMethod.POST)
    public ResponseEntity<Result> registSupplier(@RequestBody Supplier supplier) {
        try {
            accountService.registSupplier(supplier);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "注册成功"), HttpStatus.OK);
        } catch (AccountServiceException e) {
            throw new WrapperServiceException(ErrorCode.REGIST_FAILED_ERROR);
        }
    }
}
