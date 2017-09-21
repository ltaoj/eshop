package org.eshop.domain;

import org.eshop.entity.Lineitem;
import org.eshop.entity.Order;
import org.eshop.entity.Orderstatus;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/21.
 */
public class OrderDetail {
    private Order order;
    private Orderstatus orderstatus;
    private List<Lineitem> lineitems;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Orderstatus getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(Orderstatus orderstatus) {
        this.orderstatus = orderstatus;
    }

    public List<Lineitem> getLineitems() {
        return lineitems;
    }

    public void setLineitems(List<Lineitem> lineitems) {
        this.lineitems = lineitems;
    }
}
