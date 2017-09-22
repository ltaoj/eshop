package org.eshop.web;

import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.entity.Item;
import org.eshop.exception.CatelogServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
@Controller
public class CatelogActionBean extends AbstractActionBean {

    private CatelogService catelogService;

    @Autowired
    public CatelogActionBean(CatelogService catelogService) {
        this.catelogService = catelogService;
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String showHomePage() {
        return "product/main";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public ResponseEntity<Result> search(
            @RequestParam(value = "keyword", defaultValue = "") String keyword,
            @RequestParam(value = "type", defaultValue = "name") String type,
            @RequestParam(value = "byPage", defaultValue = "false") boolean byPage,
            @RequestParam(value = "page", required = false) int page,
            @RequestParam(value = "count", required = false) int count) {
        List<Item> itemList = null;
        try {
            if (byPage) {
                itemList = catelogService.searchByKeywordAndTypePaging(keyword, type, page, count);
            } else {
                itemList = catelogService.searchByKeywordAndType(keyword, type);
            }
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, itemList), HttpStatus.OK);
        } catch (CatelogServiceException e) {
            throw new WrapperServiceException(ErrorCode.SEARCH_ITEM_ERROR);
        }
    }

    @RequestMapping(value = "itemDetail", method = RequestMethod.GET)
    public String itemDetail(
            @RequestParam(value = "itemId", required = true) String itemId,
            Model model) {
        try {
            Item item = catelogService.getItem(itemId);
            model.addAttribute("item", item);
            return "product/itemInfo";
        } catch (CatelogServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_ITEM_DETAIL_FAILED);
        }
    }
}
