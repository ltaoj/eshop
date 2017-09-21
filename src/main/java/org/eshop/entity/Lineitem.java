package org.eshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Entity
@IdClass(LineitemPK.class)
public class Lineitem {
    private String orderId;
    private String itemId;
    private int quantity;
    private BigDecimal unitprice;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "unitprice")
    public BigDecimal getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(BigDecimal unitprice) {
        this.unitprice = unitprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lineitem lineitem = (Lineitem) o;

        if (quantity != lineitem.quantity) return false;
        if (orderId != null ? !orderId.equals(lineitem.orderId) : lineitem.orderId != null) return false;
        if (itemId != null ? !itemId.equals(lineitem.itemId) : lineitem.itemId != null) return false;
        if (unitprice != null ? !unitprice.equals(lineitem.unitprice) : lineitem.unitprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        return result;
    }
}
