package org.eshop.web;

import org.eshop.domain.CartItemList;
import org.eshop.domain.ErrorCode;
import org.eshop.domain.Result;
import org.eshop.entity.Cartitem;
import org.eshop.exception.CartServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/23.
 */
@Controller
public class CartActionBean extends AbstractActionBean {

    private CartService cartService;

    @Autowired
    public CartActionBean(CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(value = "addToCart", method = RequestMethod.POST)
    public ResponseEntity<Result> addToCart(@RequestBody Cartitem cartitem) {
        try {
            cartitem.setLoginId(getPrincipal());
            cartService.addToCart(cartitem);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "商品添加购物车成功"), HttpStatus.OK);
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.ADD_IETM_TO_CART_FAILED);
        }
    }

    @RequestMapping(value = "removeFromCart", method = RequestMethod.GET)
    public ResponseEntity<Result> removeFromCart(
            @RequestParam(value = "itemId", required = true) String itemId) {
        try {
            cartService.removeFromCart(itemId, getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "商品已成功移除购物车"), HttpStatus.OK);
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.REMOVE_FROM_CART_FAILED);
        }
    }

    @RequestMapping(value = "removeCartItemList", method = RequestMethod.POST)
    public ResponseEntity<Result> removeCartItemList(@RequestBody CartItemList cartItemList) {
        try {
            cartService.removeCartitemList(cartItemList.getItemIds(), getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "商品已成功移除购物车"), HttpStatus.OK);
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.REMOVE_FROM_CART_FAILED);
        }
    }

    @RequestMapping(value = "cartItemIncreasing", method = RequestMethod.GET)
    public ResponseEntity<Result> addCartitemByIncreasing(
            @RequestParam(value = "itemId", required = true) String itemId) {
        try {
            cartService.addCartitemByIncreasing(itemId, getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "购物车商品数量修改成功"), HttpStatus.OK);
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.CARTITEM_STEP_FAILED);
        }
    }

    @RequestMapping(value = "cartItemDescending", method = RequestMethod.GET)
    public ResponseEntity<Result> CartitemByIncreasing(
            @RequestParam(value = "itemId", required = true) String itemId) {
        try {
            cartService.removeCartitemByDescending(itemId, getPrincipal());
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "购物车商品数量修改成功"), HttpStatus.OK);
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.CARTITEM_STEP_FAILED);
        }
    }

    @RequestMapping(value = "viewCart", method = RequestMethod.GET)
    public String viewCart(Model model) {
        try {
            List<Cartitem> cartitemList = cartService.getCart(getPrincipal());
            model.addAttribute("cartitemList", cartitemList);
            return "cart/cart";
        } catch (CartServiceException e) {
            throw new WrapperServiceException(ErrorCode.VIEWCART_FAILED);
        }
    }
}
