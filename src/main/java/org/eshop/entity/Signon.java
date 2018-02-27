package org.eshop.entity;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/9/15.
 */
@Entity
@Table(name = "signon", schema = "eshop", catalog = "")
public class Signon {
    private String userId;
    private String password;
    private String email;
    private String phone;
    private String authorities;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "authorities")
    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Signon signon = (Signon) o;

        if (userId != null ? !userId.equals(signon.userId) : signon.userId != null) return false;
        if (password != null ? !password.equals(signon.password) : signon.password != null) return false;
        if (email != null ? !email.equals(signon.email) : signon.email != null) return false;
        if (phone != null ? !phone.equals(signon.phone) : signon.phone != null) return false;
        if (authorities != null ? !authorities.equals(signon.authorities) : signon.authorities != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (authorities != null ? authorities.hashCode() : 0);
        return result;
    }
}
