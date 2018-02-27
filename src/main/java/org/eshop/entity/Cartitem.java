package org.eshop.entity;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Entity
@Table(name = "cartitem", schema = "eshop", catalog = "")
@IdClass(CartitemPK.class)
public class Cartitem {
    private String loginId;
    private String itemId;
    private int quantity;
    private BigDecimal unitprice;

    @Id
    @Column(name = "login_id")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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

        Cartitem cartitem = (Cartitem) o;

        if (quantity != cartitem.quantity) return false;
        if (loginId != null ? !loginId.equals(cartitem.loginId) : cartitem.loginId != null) return false;
        if (itemId != null ? !itemId.equals(cartitem.itemId) : cartitem.itemId != null) return false;
        if (unitprice != null ? !unitprice.equals(cartitem.unitprice) : cartitem.unitprice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginId != null ? loginId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + (unitprice != null ? unitprice.hashCode() : 0);
        return result;
    }
}
