package org.eshop.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ltaoj on 2017/9/15.
 */
public class LineitemPK implements Serializable {
    private String orderId;
    private String itemId;

    @Column(name = "order_id")
    @Id
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Column(name = "item_id")
    @Id
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LineitemPK that = (LineitemPK) o;

        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        return result;
    }
}
