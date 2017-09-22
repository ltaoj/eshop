package org.eshop.service;

import org.eshop.entity.Item;
import org.eshop.exception.CatelogServiceException;

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
}
