package org.eshop.service;

import org.eshop.entity.Item;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public interface CatelogService {
    /**
     * 商品详情
     * @return
     */
    Item getItem(String itemId);

    /**
     * 通过商品品类分页获取商品
     * @param categoryId
     * @param page
     * @param count
     * @return
     */
    List<Item> getItemListByCategoryIdPaging(String categoryId, int page, int count);


    /**********************************管理员方法**********************************/
}
