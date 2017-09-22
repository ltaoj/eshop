package org.eshop.service.impl;

import org.eshop.domain.Constant;
import org.eshop.domain.OrderDetail;
import org.eshop.entity.*;
import org.eshop.exception.OrderServiceException;
import org.eshop.persistence.*;
import org.eshop.service.OrderService;
import org.eshop.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Service
public class OrderServiceimpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderstatusDAO orderstatusDAO;
    private LineitemDAO lineitemDAO;
    private ItemDAO itemDAO;
    private SupplierDAO supplierDAO;
    private HarvestaddrDAO harvestaddrDAO;

    @Autowired
    public OrderServiceimpl(OrderDAO orderDAO, OrderstatusDAO orderstatusDAO, LineitemDAO lineitemDAO,
                            ItemDAO itemDAO, SupplierDAO supplierDAO, HarvestaddrDAO harvestaddrDAO) {
        this.orderDAO = orderDAO;
        this.orderstatusDAO = orderstatusDAO;
        this.lineitemDAO = lineitemDAO;
        this.itemDAO = itemDAO;
        this.supplierDAO = supplierDAO;
        this.harvestaddrDAO = harvestaddrDAO;
    }

    public OrderDetail createOrder(List<Cartitem> cartitemList, Harvestaddr harvestaddr) {
        Date date = new Date();
        String orderId = StringUtil.createOrderId(date);
        Order order = new Order();
        order.setOrderId(orderId);
        Supplier supplier = supplierDAO.getSupplier(itemDAO.getItem(cartitemList.get(0).getItemId()).getSupplierId());
        order.setOriginCity(supplier.getCity());
        order.setOriginProvince(supplier.getProvince());
        order.setOrderDate(new Timestamp(date.getTime()));
        order.setLoginId(cartitemList.get(0).getLoginId());
        if (harvestaddr == null) {
            harvestaddr = harvestaddrDAO.getDefaultHarvestaddr(cartitemList.get(0).getLoginId());
        }
        order.setBillCity(harvestaddr.getCity());
        order.setBillProvince(harvestaddr.getProvince());
        order.setBillDistrict(harvestaddr.getDistrict());
        order.setBillDetailAddr(harvestaddr.getDetailAddr());
        order.setName(harvestaddr.getAliasName());

        List<Lineitem> lineitemList = new ArrayList<Lineitem>();
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0;i < cartitemList.size();i++) {
            Lineitem lineitem = new Lineitem();
            lineitem.setItemId(cartitemList.get(i).getItemId());
            lineitem.setOrderId(orderId);
            lineitem.setQuantity(cartitemList.get(i).getQuantity());
            lineitem.setUnitprice(cartitemList.get(i).getUnitprice());
            totalPrice = totalPrice.add(cartitemList.get(i).getUnitprice().multiply(new BigDecimal(cartitemList.get(i).getQuantity())));
            lineitemList.add(lineitem);
        }
        order.setTotalPrice(totalPrice);
        Orderstatus orderstatus = new Orderstatus();
        orderstatus.setDate(new Timestamp(date.getTime()));
        orderstatus.setOrderId(orderId);
        orderstatus.setStatus(Constant.ORDER_UNPAIED);

        orderDAO.insertOrder(order);
        lineitemDAO.insertLineitemList(lineitemList);
        orderstatusDAO.insertOrderstatus(orderstatus);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setLineitems(lineitemList);
        orderDetail.setOrderstatus(orderstatus);
        return orderDetail;
    }

    public List<OrderDetail> getOrderList(String loginId) {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        List<Order> orderList = orderDAO.getOrderListByLoginId(loginId);
        for (int i = 0;i < orderList.size();i++) {
            OrderDetail orderDetail = new OrderDetail();
            List<Lineitem> lineitemList = lineitemDAO.getLineitemListByOrderId(orderList.get(i).getOrderId());
            Orderstatus orderstatus = orderstatusDAO.getOrderstatus(orderList.get(i).getOrderId());
            orderDetail.setOrder(orderList.get(i));
            orderDetail.setLineitems(lineitemList);
            orderDetail.setOrderstatus(orderstatus);
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }

    public List<OrderDetail> getOrderListByStatus(String loginId, int status) throws OrderServiceException {
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        List<Order> orderList = orderDAO.getOrderListByLoginId(loginId);
        for (int i = 0;i < orderList.size();i++) {
            Orderstatus orderstatus = orderstatusDAO.getOrderstatus(orderList.get(i).getOrderId());
            if (orderstatus.getStatus() != status) continue;
            OrderDetail orderDetail = new OrderDetail();
            List<Lineitem> lineitemList = lineitemDAO.getLineitemListByOrderId(orderList.get(i).getOrderId());
            orderDetail.setOrder(orderList.get(i));
            orderDetail.setLineitems(lineitemList);
            orderDetail.setOrderstatus(orderstatus);
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }

    public OrderDetail getOrderDetail(String orderId) {
        Order order = orderDAO.getOrder(orderId);
        List<Lineitem> lineitemList = lineitemDAO.getLineitemListByOrderId(orderId);
        Orderstatus orderstatus = orderstatusDAO.getOrderstatus(orderId);
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrder(order);
        orderDetail.setOrderstatus(orderstatus);
        orderDetail.setLineitems(lineitemList);
        return orderDetail;
    }

    public void cancelOrder(String orderId) {
        Orderstatus orderstatus = orderstatusDAO.getOrderstatus(orderId);
        orderstatus.setStatus(Constant.ORDER_CANCELED);
        orderstatusDAO.updateOrderstatus(orderstatus);
    }

    public void deleteOrder(String orderId) {
        orderstatusDAO.deleteOrderstatus(orderId);
        lineitemDAO.deleteLineitemByOrderId(orderId);
        orderDAO.deleteOrder(orderId);
    }
}
