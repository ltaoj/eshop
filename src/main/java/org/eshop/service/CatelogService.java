package org.eshop.service;

import org.eshop.entity.Category;
import org.eshop.entity.Inventory;
import org.eshop.entity.Item;
import org.eshop.exception.CatelogServiceException;
import org.eshop.exception.HandleFileUploadException;
import org.eshop.exception.TransationException;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public interface CatelogService {
    /**
     * 商品详情
     * @return
     */
    Item getItem(String itemId) throws CatelogServiceException;

    /**
     * 通过关键字和检索类型查询
     * @param keyword
     * @param type
     * @return
     */
    List<Item> searchByKeywordAndType(String keyword, String type) throws CatelogServiceException;

    /**
     * 通过关键字、检索类型分页查询
     * @param keyword
     * @param type
     * @param page
     * @param count
     * @return
     */
    List<Item> searchByKeywordAndTypePaging(String keyword, String type, int page, int count) throws CatelogServiceException;
    /**********************************管理员方法**********************************/

    /**
     * 添加商品
     * @param item
     * @throws TransationException
     */
    void addItem(Item item) throws TransationException;

    /**
     * 获取商品列表
     * @return
     * @throws CatelogServiceException
     */
    List<Item> getItemList() throws CatelogServiceException;

    /**
     * 获取商品库存
     * @return
     * @throws CatelogServiceException
     */
    Inventory getInventory(String itemId) throws CatelogServiceException;

    /**
     * 获取品类列表
     * @return
     * @throws CatelogServiceException
     */
    List<Category> getCategoryList() throws CatelogServiceException;

    /**
     * 添加品类
     * @throws CatelogServiceException
     */
    void addCategory(Category category) throws CatelogServiceException;

    /**
     * 删除品类
     * @param category
     * @throws CatelogServiceException
     */
    void deleteCategory(Category category) throws CatelogServiceException;
}
