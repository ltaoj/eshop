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
     * 通过关键字获取商品列表，模糊查询
     * @param keyword
     * @return
     * @throws PersistenceException
     */
    List<Item> getItemListByKeyword(String keyword) throws PersistenceException;

    /**
     * 通过关键字获取商品列表，分页查询
     * @param keyword
     * @param offset
     * @param count
     * @return
     */
    List<Item> getItemListByKeywordPaging(String keyword, int offset, int count);

    /**
     * 通过商品属性检索商品
     * @param keyword
     * @param type
     * @return
     */
    List<Item> getItemListByAttr(String keyword, String type);

    /**
     * 通过商品属性分页检索商品
     * @param keyword
     * @param type
     * @param offset
     * @param count
     * @return
     */
    List<Item> getItemListByAttrPaging(String keyword, String type, int offset, int count);

    /**
     * 获取所有商品
     * @return
     */
    List<Item> getAllItem();
}
