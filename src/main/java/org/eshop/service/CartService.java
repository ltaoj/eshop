package org.eshop.service;

import org.eshop.entity.Cartitem;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public interface CartService {
    /**
     * 商品添加购物车
     * @param cartitem
     */
    void addToCart(Cartitem cartitem);

    /**
     * 将商品从购物车移除
     * @param itemId
     * @param loginId
     */
    void removeFromCart(String itemId, String loginId);

    /**
     * 将多个商品从购物车移除
     * @param itemIds
     * @param loginId
     */
    void removeCartitemList(List<String> itemIds, String loginId);

    /**
     * 递增商品个数
     * @param itemId
     * @param loginId
     */
    void addCartitemByIncreasing(String itemId, String loginId);

    /**
     * 递减商品个数
     * @param itemId
     * @param loginId
     */
    void removeCartitemByDescending(String itemId, String loginId);

    /**
     * 查看购物车
     * @param loginId
     * @return
     */
    List<Cartitem> getCart(String loginId);
}