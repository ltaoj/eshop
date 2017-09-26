package org.eshop.web;

import org.eshop.domain.BigItem;
import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.entity.Inventory;
import org.eshop.entity.Item;
import org.eshop.entity.Supplier;
import org.eshop.exception.*;
import org.eshop.service.AccountService;
import org.eshop.service.CatelogService;
import org.eshop.service.OrderService;
import org.eshop.util.ConfigUtil;
import org.eshop.util.IOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/25.
 */
@Controller
public class AdminActionBean extends AbstractActionBean{

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
    public String showItem(Model model) {
        try {
            List<Item> itemList = catelogService.getItemList();
            List<BigItem> bigItemList = new ArrayList<BigItem>();
            for (int i = 0;i < itemList.size();i++) {
                BigItem bigItem = new BigItem();
                bigItem.setItem(itemList.get(i));
                Inventory inventory = catelogService.getInventory(itemList.get(i).getItemId());
                bigItem.setInventory(inventory);
                bigItemList.add(bigItem);
            }
            model.addAttribute("bigItemList", bigItemList);
            return "admin/item";
        } catch (CatelogServiceException e) {
            throw new WrapperServiceException(ErrorCode.SEARCH_ITEM_ERROR);
        }
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

    @RequestMapping(value = "addItem", method = RequestMethod.POST)
    public ResponseEntity<Result> addItem(@RequestPart("itemPic") MultipartFile itemPic,
                                          Item item, HttpServletRequest request) throws HandleFileUploadException {
        String path = request.getSession().getServletContext().getRealPath("upImg");
        ConfigUtil.setPath(path);
        try {
            String fileName = itemPic.getOriginalFilename();
            String targetName = item.getItemId() + "_" + fileName;
            String picName = IOUtil.saveFile(targetName, path, itemPic);
            item.setDescription("upImg/" + picName);
            item.setSupplierId(getPrincipal());
            catelogService.addItem(item);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "商品添加成功"), HttpStatus.OK);
        } catch (IOException e) {
            throw new HandleFileUploadException(e);
        } catch (TransationException e) {
            throw new HandleTransationException(e);
        }
    }


}
