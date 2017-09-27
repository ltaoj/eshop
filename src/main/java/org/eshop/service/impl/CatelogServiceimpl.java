package org.eshop.service.impl;

import org.eshop.domain.Constant;
import org.eshop.entity.Category;
import org.eshop.entity.Inventory;
import org.eshop.entity.Item;
import org.eshop.exception.CatelogServiceException;
import org.eshop.exception.TransationException;
import org.eshop.persistence.CategoryDAO;
import org.eshop.persistence.InventoryDAO;
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
    private InventoryDAO inventoryDAO;

    @Autowired
    public CatelogServiceimpl(CategoryDAO categoryDAO, ItemDAO itemDAO) {
        this.categoryDAO = categoryDAO;
        this.itemDAO = itemDAO;
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public List<Item> searchByKeywordAndType(String keyword, String type) {
        List<Item> itemList = null;
        if (type.equals(Constant.SEARCH_BY_ATTR_COLOR) || type.equals(Constant.SEARCH_BY_ATTR_SHAPE)) {
            itemList = itemDAO.getItemListByAttr(keyword, type);
        }else {
            itemList = itemDAO.getItemListByKeyword(keyword);
        }
        return itemList;
    }

    public List<Item> searchByKeywordAndTypePaging(String keyword, String type, int page, int count) {
        List<Item> itemList = null;
        if (type.equals(Constant.SEARCH_BY_ATTR_COLOR) || type.equals(Constant.SEARCH_BY_ATTR_SHAPE)) {
            itemList = itemDAO.getItemListByAttrPaging(keyword, type, (page == 0 ? 0 : (page - 1) * count), count);
        }else {
            itemList = itemDAO.getItemListByKeywordPaging(keyword, (page == 0 ? 0 : (page - 1) * count), count);
        }
        return itemList;
    }

    public void addItem(Item item) throws TransationException {
        try {
            itemDAO.insertItem(item);
            Inventory inventory = new Inventory();
            inventory.setItemId(item.getItemId());
            inventory.setInveQuan(0);
            inventoryDAO.insertInventory(inventory);
        } catch (RuntimeException e) {
            throw new TransationException(item);
        }
    }

    public List<Item> getItemList() throws CatelogServiceException {
        return itemDAO.getAllItem();
    }

    public Inventory getInventory(String itemId) throws CatelogServiceException {
        return inventoryDAO.getInventory(itemId);
    }

    public List<Category> getCategoryList() throws CatelogServiceException {
        return categoryDAO.getAllCategory();
    }

    public void addCategory(Category category) throws CatelogServiceException {
        categoryDAO.insertCategory(category);
    }

    public void deleteCategory(Category category) throws CatelogServiceException {
        categoryDAO.deleteCategory(category.getCategoryId());
    }
}
