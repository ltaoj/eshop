package org.eshop.persistence;

import org.eshop.entity.Orderstatus;

import javax.persistence.PersistenceException;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface OrderstatusDAO {
    /**
     * 添加订单状态
     * @param orderstatus
     * @throws PersistenceException
     */
    void insertOrderstatus(Orderstatus orderstatus) throws PersistenceException;

    /**
     * 删除订单状态
     * @param orderId
     * @throws PersistenceException
     */
    void deleteOrderstatus(String orderId)  throws PersistenceException;

    /**
     * 更新订单状态
     * @param orderstatus
     * @throws PersistenceException
     */
    void updateOrderstatus(Orderstatus orderstatus) throws PersistenceException;

    /**
     * 获取订单状态
     * @param orderId
     * @return
     * @throws PersistenceException
     */
    Orderstatus getOrderstatus(String orderId) throws PersistenceException;
}
