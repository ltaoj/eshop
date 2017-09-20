package org.eshop.persistence;

import org.eshop.entity.Cartitem;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface CartitemDAO {

    /**
     * 将商品添加到购物车
     * @param cartitem
     * @throws PersistenceException
     */
    void insertCartitem(Cartitem cartitem) throws PersistenceException;

    /**
     * 将商品从购物车删除
     * @param itemId
     * @throws PersistenceException
     */
    void deleteCartitem(String itemId, String loginId) throws PersistenceException;

    /**
     * 删除多个商品
     * @param itemIds
     * @throws PersistenceException
     */
    void deleteCartitemList(List<String> itemIds, String loginId) throws PersistenceException;

    /**
     * 更新购物车商品
     * @param cartitem
     * @throws PersistenceException
     */
    void updateCartitem(Cartitem cartitem) throws PersistenceException;

    /**
     * 获取购物车所有商品
     * @param loginId
     * @return
     * @throws PersistenceException
     */
    List<Cartitem> getCartitemList(String loginId) throws PersistenceException;
}