package org.eshop.persistence;

import org.eshop.entity.Order;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/20.
 */
public interface OrderDAO {

    /**
     * 创建订单信息
     * @param order
     * @return
     * @throws PersistenceException
     */
    String insertOrder(Order order) throws PersistenceException;

    /**
     * 删除订单信息
     * @param orderId
     * @throws PersistenceException
     */
    void deleteOrder(String orderId) throws PersistenceException;

    /**
     * 获取订单列表
     * @param loginId
     * @return
     * @throws PersistenceException
     */
    List<Order> getOrderListByLoginId(String loginId) throws PersistenceException;

    /**
     * 获取订单信息
     * @param orderId
     * @return
     * @throws PersistenceException
     */
    Order getOrder(String orderId) throws PersistenceException;
}
