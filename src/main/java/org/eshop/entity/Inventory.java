package org.eshop.entity;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/9/15.
 */
@Entity
@Table(name = "inventory", schema = "eshop", catalog = "")
public class Inventory {
    private String itemId;
    private int inveQuan;

    @Id
    @Column(name = "item_id")
    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Basic
    @Column(name = "inve_quan")
    public int getInveQuan() {
        return inveQuan;
    }

    public void setInveQuan(int inveQuan) {
        this.inveQuan = inveQuan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Inventory inventory = (Inventory) o;

        if (inveQuan != inventory.inveQuan) return false;
        if (itemId != null ? !itemId.equals(inventory.itemId) : inventory.itemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = itemId != null ? itemId.hashCode() : 0;
        result = 31 * result + inveQuan;
        return result;
    }
}
