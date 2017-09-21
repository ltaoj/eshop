package org.eshop.service.impl;

import org.eshop.entity.Item;
import org.eshop.persistence.CategoryDAO;
import org.eshop.persistence.ItemDAO;
import org.eshop.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Service
public class CatelogServiceimpl implements CatelogService {

    private CategoryDAO categoryDAO;
    private ItemDAO itemDAO;

    @Autowired
    public CatelogServiceimpl(CategoryDAO categoryDAO, ItemDAO itemDAO) {
        this.categoryDAO = categoryDAO;
        this.itemDAO = itemDAO;
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public List<Item> getItemListByCategoryIdPaging(String categoryId, int page, int count) {
        return itemDAO.getItemListByCategoryIdPaging(categoryId, (page == 0 ? 0 : (page - 1) * count), count);
    }
}
