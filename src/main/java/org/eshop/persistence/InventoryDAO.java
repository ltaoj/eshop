package org.eshop.persistence;

import org.eshop.entity.Inventory;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface InventoryDAO {

    /**
     * 更新库存
     * @param inventory
     * @throws PersistenceException
     */
    void updateInventory(Inventory inventory) throws PersistenceException;

    /**
     * 根据商品id获取库存
     * @param itemId
     * @return
     * @throws PersistenceException
     */
    List<Inventory> getInventory(String itemId) throws PersistenceException;
}