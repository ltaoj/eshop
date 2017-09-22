package org.eshop.domain;

import org.eshop.entity.Cartitem;
import org.eshop.entity.Harvestaddr;

import java.util.List;

/**
 * Created by ltaoj on 2017/9/23.
 */
public class OrderNeeded {

    private List<Cartitem> cartitemList;
    private Harvestaddr harvestaddr;

    public List<Cartitem> getCartitemList() {
        return cartitemList;
    }

    public void setCartitemList(List<Cartitem> cartitemList) {
        this.cartitemList = cartitemList;
    }

    public Harvestaddr getHarvestaddr() {
        return harvestaddr;
    }

    public void setHarvestaddr(Harvestaddr harvestaddr) {
        this.harvestaddr = harvestaddr;
    }
}
