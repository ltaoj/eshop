package org.eshop.persistence;

import org.eshop.entity.Category;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface CategoryDAO {
    /**
     * 添加商品品类
     * @param category
     * @throws PersistenceException
     */
    void insertCategory(Category category) throws PersistenceException;

    /**
     * 获取商品品类
     * @param categoryId
     * @throws PersistenceException
     */
    Category getCategory(String categoryId) throws PersistenceException;

    /**
     * 获取所有商品品类
     * @return
     * @throws PersistenceException
     */
    List<Category> getAllCategory() throws PersistenceException;

    /**
     * 删除商品品类
     * @param categoryId
     * @throws PersistenceException
     */
    void deleteCategory(String categoryId) throws PersistenceException;
}
