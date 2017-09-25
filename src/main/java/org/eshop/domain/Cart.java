package org.eshop.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/26.
 */
public class Cart {
    private List<CartItemItem> cartItemItemList;

    public List<CartItemItem> getCartItemItemList() {
        return cartItemItemList;
    }

    public void setCartItemItemList(List<CartItemItem> cartItemItemList) {
        this.cartItemItemList = cartItemItemList;
    }

    public BigDecimal totalPrice() {
        BigDecimal bigDecimal = new BigDecimal(0);
        for (int i = 0;i < cartItemItemList.size();i++) {
            bigDecimal.add(cartItemItemList.get(i).getUnitprice());
        }
        return bigDecimal;
    }
}
