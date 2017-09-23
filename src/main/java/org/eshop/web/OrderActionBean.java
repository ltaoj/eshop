package org.eshop.web;

import org.eshop.domain.*;
import org.eshop.exception.OrderServiceException;
import org.eshop.exception.WrapperServiceException;
import org.eshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/23.
 */
@Controller
public class OrderActionBean extends AbstractActionBean {

    private OrderService orderService;

    @Autowired
    public OrderActionBean(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "createOrder", method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderNeeded orderNeeded) {
        try {
            OrderDetail orderDetail = orderService.createOrder(orderNeeded.getCartitemList(), orderNeeded.getHarvestaddr());
            return "redirect:/orderDetail?orderId=" + orderDetail.getOrders().getOrderId();
        } catch (OrderServiceException e) {
            throw new WrapperServiceException(ErrorCode.CREATE_ORDER_FAILED);
        }
    }

    @RequestMapping(value = "orderDetail", method = RequestMethod.GET)
    public String getOrderDetail(
            @RequestParam(value = "orderId") String orderId,
            Model model) {
        try {
            OrderDetail orderDetail = orderService.getOrderDetail(orderId);
            model.addAttribute("orderDetail", orderDetail);
            return "order/orderDetail";
        } catch (OrderServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_ORDER_DETAIL_FAILED);
        }
    }

    @RequestMapping(value = "orderList", method = RequestMethod.GET)
    public String getOrderList(Model model) {
        try {
            List<OrderDetail> allOrderDetailList = orderService.getOrderList(getPrincipal());
            List<OrderDetail> unPayOrderDetailList = orderService.getOrderListByStatus(getPrincipal(), Constant.ORDER_UNPAY_STATUS);
            List<OrderDetail> cancelOrderDetailList = orderService.getOrderListByStatus(getPrincipal(), Constant.ORDER_CANCEL_STATUS);
            model.addAttribute("allOrderDetailList", allOrderDetailList);
            model.addAttribute("unPayOrderDetailList", unPayOrderDetailList);
            model.addAttribute("cancelOrderDetailList", cancelOrderDetailList);
            return "order/order";
        } catch (OrderServiceException e) {
            throw new WrapperServiceException(ErrorCode.GET_ORDER_LIST_FAILED);
        }
    }

    @RequestMapping(value = "cancelOrder", method = RequestMethod.GET)
    public ResponseEntity<Result> cancelOrder(@RequestParam(value = "orderId") String orderId) {
        try {
            orderService.cancelOrder(orderId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "订单取消成功"), HttpStatus.OK);
        } catch (OrderServiceException e) {
            throw new WrapperServiceException(ErrorCode.CANCEL_ORDER_FAILED);
        }
    }

    @RequestMapping(value = "delOrder", method = RequestMethod.GET)
    public ResponseEntity<Result> deleteOrder(@RequestParam(value = "orderId") String orderId) {
        try {
            orderService.deleteOrder(orderId);
            return new ResponseEntity<Result>(new Result(Result.RESULT_SUCCESS, "订单删除成功"), HttpStatus.OK);
        } catch (OrderServiceException e) {
            throw new WrapperServiceException(ErrorCode.DELETE_ORDER_FAILED);
        }
    }
}
