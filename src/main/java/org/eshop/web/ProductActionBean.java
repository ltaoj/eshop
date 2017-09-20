package org.eshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Controller
public class ProductActionBean extends AbstractActionBean {

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "product/main";
    }
}
