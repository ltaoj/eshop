package org.eshop.service.impl;

import org.eshop.entity.Cartitem;
import org.eshop.persistence.CartitemDAO;
import org.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Service
public class CartServiceimpl implements CartService{

    private CartitemDAO cartitemDAO;

    @Autowired
    public CartServiceimpl(CartitemDAO cartitemDAO) {
        this.cartitemDAO = cartitemDAO;
    }

    public void addToCart(Cartitem cartitem) {
        cartitemDAO.insertCartitem(cartitem);
    }

    public void removeFromCart(String itemId, String loginId) {
        cartitemDAO.deleteCartitem(itemId, loginId);
    }

    public void removeCartitemList(List<String> itemIds, String loginId) {
        cartitemDAO.deleteCartitemList(itemIds, loginId);
    }

    public void addCartitemByIncreasing(String itemId, String loginId) {
        Cartitem cartitem = cartitemDAO.getCartitem(itemId, loginId);
        cartitem.setQuantity(cartitem.getQuantity() + 1);
        cartitemDAO.updateCartitem(cartitem);
    }

    public void removeCartitemByDescending(String itemId, String loginId) {
        Cartitem cartitem = cartitemDAO.getCartitem(itemId, loginId);
        int quantity = cartitem.getQuantity();
        if (quantity <= 1) {
            cartitemDAO.deleteCartitem(itemId, loginId);
        } else {
            cartitem.setQuantity(quantity - 1);
            cartitemDAO.updateCartitem(cartitem);
        }
    }

    public List<Cartitem> getCart(String loginId) {
        return cartitemDAO.getCartitemList(loginId);
    }
}
