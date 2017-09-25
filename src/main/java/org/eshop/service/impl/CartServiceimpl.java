package org.eshop.service.impl;

import org.eshop.domain.CartItemItem;
import org.eshop.entity.Cartitem;
import org.eshop.entity.Item;
import org.eshop.persistence.CartitemDAO;
import org.eshop.persistence.ItemDAO;
import org.eshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Service
public class CartServiceimpl implements CartService{

    private CartitemDAO cartitemDAO;
    private ItemDAO itemDAO;

    @Autowired
    public CartServiceimpl(CartitemDAO cartitemDAO, ItemDAO itemDAO) {
        this.cartitemDAO = cartitemDAO;
        this.itemDAO = itemDAO;
    }

    public void addToCart(Cartitem cartitem) {
        Cartitem cartitem1 = cartitemDAO.getCartitem(cartitem.getItemId(), cartitem.getLoginId());
        if (cartitem1 != null) {
            cartitem.setQuantity(cartitem.getQuantity() + cartitem1.getQuantity());
            cartitemDAO.updateCartitem(cartitem);
        }else {
            cartitemDAO.insertCartitem(cartitem);
        }
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

    public List<CartItemItem> getCart(String loginId) {
        List<Cartitem> cartitemList = cartitemDAO.getCartitemList(loginId);
        List<CartItemItem> cartItemItemList = new ArrayList<CartItemItem>();
        for (int i = 0;i < cartitemList.size();i++) {
            CartItemItem cartItemItem = new CartItemItem();
            cartItemItem.setItemId(cartitemList.get(i).getItemId());
            cartItemItem.setQuantity(cartitemList.get(i).getQuantity());
            cartItemItem.setUnitprice(cartitemList.get(i).getUnitprice());
            Item item = itemDAO.getItem(cartitemList.get(i).getItemId());
            cartItemItem.setName(item.getName());
            cartItemItem.setDescription(item.getDescription());
            cartItemItemList.add(cartItemItem);
        }
        return cartItemItemList;
    }
}
