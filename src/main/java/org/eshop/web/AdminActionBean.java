package org.eshop.web;

import org.eshop.service.AccountService;
import org.eshop.service.CatelogService;
import org.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String showSupplier() {
        return "admin/supplier";
    }
}
