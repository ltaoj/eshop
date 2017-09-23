package org.eshop.service;

import org.eshop.domain.OrderDetail;
import org.eshop.entity.Cartitem;
import org.eshop.entity.Harvestaddr;
import org.eshop.exception.OrderServiceException;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public interface OrderService {
    /**
     * 创建订单
     * @return
     */
    OrderDetail createOrder(List<Cartitem> cartitemList, Harvestaddr harvestaddr) throws OrderServiceException;

    /**
     * 获取全部订单
     * @param loginId
     * @return
     * @throws OrderServiceException
     */
    List<OrderDetail> getOrderList(String loginId) throws OrderServiceException;

    /**
     * 通过订单状态获取订单列表
     * @param loginId
     * @param status
     * @return
     * @throws OrderServiceException
     */
    List<OrderDetail> getOrderListByStatus(String loginId, int status) throws OrderServiceException;

    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    OrderDetail getOrderDetail(String orderId) throws OrderServiceException;

    /**
     * 取消订单
     * @param orderId
     */
    void cancelOrder(String orderId) throws OrderServiceException;

    /**
     * 删除订单
     * @param orderId
     */
    void deleteOrder(String orderId) throws OrderServiceException;
}
