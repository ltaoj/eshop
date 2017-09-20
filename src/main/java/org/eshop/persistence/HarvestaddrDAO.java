package org.eshop.persistence;

import org.eshop.entity.Harvestaddr;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface HarvestaddrDAO {
    /**
     * 添加收获地址
     * @param harvestaddr
     * @throws PersistenceException
     */
    void insertHarvestaddr(Harvestaddr harvestaddr) throws PersistenceException;

    /**
     * 删除收获地址
     * @param addrId
     * @throws PersistenceException
     */
    void deleteHarvestaddr(int addrId) throws PersistenceException;

    /**
     * 更新收货地址
     * @param harvestaddr
     * @throws PersistenceException
     */
    void updateHarvestaddr(Harvestaddr harvestaddr) throws PersistenceException;

    /**
     * 设置默认收获地址
     * @param harvestaddr
     * @throws PersistenceException
     */
    void setDefaultHarvestaddr(int harvestaddr) throws PersistenceException;

    /**
     * 获取默认收获地址
     * @return
     * @throws PersistenceException
     */
    Harvestaddr getDefaultHarvestaddr() throws PersistenceException;


}
