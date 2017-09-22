package org.eshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Controller
public class TestActionBean extends AbstractActionBean {

    @RequestMapping(value = "viewCart", method = RequestMethod.GET)
    public String showCart() {
        return "cart/cart";
    }


    @RequestMapping(value = "itemDetail", method = RequestMethod.GET)
    public String showItemDetail() {
        return "product/itemInfo";
    }

    @RequestMapping(value = "colorRes", method = RequestMethod.GET)
    public String showColorResult() {
        return "product/searchByColor";
    }

    @RequestMapping(value = "shapeRes", method = RequestMethod.GET)
    public String showShapeResult() {
        return "product/searchByShape";
    }

    @RequestMapping(value = "addrModal", method = RequestMethod.GET)
    public String showAddrModal() {
        return "account/addAddress";
    }
}
