package org.eshop.entity;

import javax.persistence.*;

/**
 * Created by ltaoj on 2017/9/15.
 */
@Entity
@Table(name = "userinfo", schema = "eshop", catalog = "")
public class Userinfo {
    private String loginId;
    private String email;
    private String phone;
    private Integer sex;
    private String name;
    private int status;

    @Id
    @Column(name = "login_id")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Userinfo userinfo = (Userinfo) o;

        if (status != userinfo.status) return false;
        if (loginId != null ? !loginId.equals(userinfo.loginId) : userinfo.loginId != null) return false;
        if (email != null ? !email.equals(userinfo.email) : userinfo.email != null) return false;
        if (phone != null ? !phone.equals(userinfo.phone) : userinfo.phone != null) return false;
        if (sex != null ? !sex.equals(userinfo.sex) : userinfo.sex != null) return false;
        if (name != null ? !name.equals(userinfo.name) : userinfo.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginId != null ? loginId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }
}
