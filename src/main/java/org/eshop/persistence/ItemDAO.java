package org.eshop.persistence;

import org.eshop.entity.Item;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface ItemDAO {
    /**
     * 添加商品
     * @param item
     * @throws PersistenceException
     */
    void insertItem(Item item) throws PersistenceException;

    /**
     * 更新商品信息
     * @param item
     * @throws PersistenceException
     */
    void updateItem(Item item) throws PersistenceException;

    /**
     * 根据商品id获取商品
     * @param itemId
     * @return
     * @throws PersistenceException
     */
    Item getItem(String itemId) throws PersistenceException;

    /**
     * 根据商品品类分页获取所有商品
     * @param categoryId
     * @param page
     * @param count
     * @return
     * @throws PersistenceException
     */
    List<Item> getItemListByCategoryIdPaging(String categoryId, int page, int count) throws PersistenceException;

    /**
     * 通过关键字获取商品列表，模糊查询
     * @param keyword
     * @return
     * @throws PersistenceException
     */
    List<Item> getItemListByKeyword(String keyword) throws PersistenceException;
}
