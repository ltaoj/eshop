package org.eshop.persistence;

import org.eshop.entity.Orders;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface OrderDAO {

    /**
     * 创建订单信息
     * @param Orders
     * @return
     * @throws PersistenceException
     */
    String insertOrder(Orders Orders) throws PersistenceException;

    /**
     * 删除订单信息
     * @param OrderId
     * @throws PersistenceException
     */
    void deleteOrder(String OrderId) throws PersistenceException;

    /**
     * 获取订单列表
     * @param loginId
     * @return
     * @throws PersistenceException
     */
    List<Orders> getOrderListByLoginId(String loginId) throws PersistenceException;

    /**
     * 获取订单信息
     * @param OrderId
     * @return
     * @throws PersistenceException
     */
    Orders getOrder(String OrderId) throws PersistenceException;
}
