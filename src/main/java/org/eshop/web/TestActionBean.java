package org.eshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Controller
public class TestActionBean extends AbstractActionBean {

    @RequestMapping(value = "colorRes", method = RequestMethod.GET)
    public String showColorResult() {
        return "product/searchByColor";
    }

    @RequestMapping(value = "shapeRes", method = RequestMethod.GET)
    public String showShapeResult() {
        return "product/searchByShape";
    }

    @RequestMapping(value = "myOrder", method = RequestMethod.GET)
    public String showOrder() {
        return "order/order";
    }

    @RequestMapping(value = "orderDetail", method = RequestMethod.GET)
    public String showOrderDetail() {
        return "order/orderDetail";
    }
}