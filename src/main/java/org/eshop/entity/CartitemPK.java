package org.eshop.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by ltaoj on 2017/9/21.
 */
public class CartitemPK implements Serializable {
    private String loginId;
    private String itemId;

    @Column(name = "login_id")
    @Id
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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

        CartitemPK that = (CartitemPK) o;

        if (loginId != null ? !loginId.equals(that.loginId) : that.loginId != null) return false;
        if (itemId != null ? !itemId.equals(that.itemId) : that.itemId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginId != null ? loginId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        return result;
    }
}
