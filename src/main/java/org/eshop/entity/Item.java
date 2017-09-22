package org.eshop.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by ltaoj on 2017/9/21.
 */
@Entity
public class Item {
    private String itemId;
    private String name;
    private String categoryId;
    private String supplierId;
    private BigDecimal listprice;
    private BigDecimal unitcost;
    private String description;
    private int isStock;
    private String attr1;
    private String attr2;
    private String attr3;

    @Id
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "category_id")
    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "supplier_id")
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "listprice")
    public BigDecimal getListprice() {
        return listprice;
    }

    public void setListprice(BigDecimal listprice) {
        this.listprice = listprice;
    }

    @Basic
    @Column(name = "unitcost")
    public BigDecimal getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(BigDecimal unitcost) {
        this.unitcost = unitcost;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "isStock")
    public int getIsStock() {
        return isStock;
    }

    public void setIsStock(int isStock) {
        this.isStock = isStock;
    }

    @Basic
    @Column(name = "attr1")
    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    @Basic
    @Column(name = "attr2")
    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    @Basic
    @Column(name = "attr3")
    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (isStock != item.isStock) return false;
        if (itemId != null ? !itemId.equals(item.itemId) : item.itemId != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        if (categoryId != null ? !categoryId.equals(item.categoryId) : item.categoryId != null) return false;
        if (supplierId != null ? !supplierId.equals(item.supplierId) : item.supplierId != null) return false;
        if (listprice != null ? !listprice.equals(item.listprice) : item.listprice != null) return false;
        if (unitcost != null ? !unitcost.equals(item.unitcost) : item.unitcost != null) return false;
        if (description != null ? !description.equals(item.description) : item.description != null) return false;
        if (attr1 != null ? !attr1.equals(item.attr1) : item.attr1 != null) return false;
        if (attr2 != null ? !attr2.equals(item.attr2) : item.attr2 != null) return false;
        if (attr3 != null ? !attr3.equals(item.attr3) : item.attr3 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (supplierId != null ? supplierId.hashCode() : 0);
        result = 31 * result + (listprice != null ? listprice.hashCode() : 0);
        result = 31 * result + (unitcost != null ? unitcost.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + isStock;
        result = 31 * result + (attr1 != null ? attr1.hashCode() : 0);
        result = 31 * result + (attr2 != null ? attr2.hashCode() : 0);
        result = 31 * result + (attr3 != null ? attr3.hashCode() : 0);
        return result;
    }
}
