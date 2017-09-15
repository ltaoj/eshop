package org.eshop.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by ltaoj on 2017/9/15.
 */
@Entity
public class Order {
    private String orderId;
    private Timestamp orderDate;
    private String loginId;
    private String originProvince;
    private String originCity;
    private String billProvince;
    private String billCity;
    private String billDistrict;
    private String billDetailAddr;
    private String name;
    private int totalPrice;

    @Id
    @Column(name = "order_id")
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "order_date")
    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Basic
    @Column(name = "login_id")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    @Basic
    @Column(name = "origin_province")
    public String getOriginProvince() {
        return originProvince;
    }

    public void setOriginProvince(String originProvince) {
        this.originProvince = originProvince;
    }

    @Basic
    @Column(name = "origin_city")
    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    @Basic
    @Column(name = "bill_province")
    public String getBillProvince() {
        return billProvince;
    }

    public void setBillProvince(String billProvince) {
        this.billProvince = billProvince;
    }

    @Basic
    @Column(name = "bill_city")
    public String getBillCity() {
        return billCity;
    }

    public void setBillCity(String billCity) {
        this.billCity = billCity;
    }

    @Basic
    @Column(name = "bill_district")
    public String getBillDistrict() {
        return billDistrict;
    }

    public void setBillDistrict(String billDistrict) {
        this.billDistrict = billDistrict;
    }

    @Basic
    @Column(name = "bill_detail_addr")
    public String getBillDetailAddr() {
        return billDetailAddr;
    }

    public void setBillDetailAddr(String billDetailAddr) {
        this.billDetailAddr = billDetailAddr;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "total_price")
    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (totalPrice != order.totalPrice) return false;
        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (orderDate != null ? !orderDate.equals(order.orderDate) : order.orderDate != null) return false;
        if (loginId != null ? !loginId.equals(order.loginId) : order.loginId != null) return false;
        if (originProvince != null ? !originProvince.equals(order.originProvince) : order.originProvince != null)
            return false;
        if (originCity != null ? !originCity.equals(order.originCity) : order.originCity != null) return false;
        if (billProvince != null ? !billProvince.equals(order.billProvince) : order.billProvince != null) return false;
        if (billCity != null ? !billCity.equals(order.billCity) : order.billCity != null) return false;
        if (billDistrict != null ? !billDistrict.equals(order.billDistrict) : order.billDistrict != null) return false;
        if (billDetailAddr != null ? !billDetailAddr.equals(order.billDetailAddr) : order.billDetailAddr != null)
            return false;
        if (name != null ? !name.equals(order.name) : order.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (loginId != null ? loginId.hashCode() : 0);
        result = 31 * result + (originProvince != null ? originProvince.hashCode() : 0);
        result = 31 * result + (originCity != null ? originCity.hashCode() : 0);
        result = 31 * result + (billProvince != null ? billProvince.hashCode() : 0);
        result = 31 * result + (billCity != null ? billCity.hashCode() : 0);
        result = 31 * result + (billDistrict != null ? billDistrict.hashCode() : 0);
        result = 31 * result + (billDetailAddr != null ? billDetailAddr.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + totalPrice;
        return result;
    }
}
