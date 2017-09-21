package org.eshop.service;

import org.eshop.domain.OrderDetail;
import org.eshop.entity.Cartitem;
import org.eshop.entity.Harvestaddr;
import org.eshop.entity.Order;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public interface OrderService {
    /**
     * 创建订单
     * @return
     */
    OrderDetail createOrder(List<Cartitem> cartitemList, Harvestaddr harvestaddr);

    /**
     * 获取订单列表
     * @param loginId
     * @return
     */
    List<Order> getOrderList(String loginId);

    /**
     * 获取订单详情
     * @param orderId
     * @return
     */
    OrderDetail getOrderDetail(String orderId);

    /**
     * 取消订单
     * @param orderId
     */
    void cancelOrder(String orderId);

    /**
     * 删除订单
     * @param orderId
     */
    void deleteOrder(String orderId);
}
