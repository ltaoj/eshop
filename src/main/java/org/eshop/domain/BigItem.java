package org.eshop.domain;

import org.eshop.entity.Inventory;
import org.eshop.entity.Item;

/**
 * Created by ltaoj on 2017/9/26.
 */
public class BigItem {
    private Item item;
    private Inventory inventory;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
