package org.eshop.domain;

import org.eshop.entity.Signon;

/**
 * Created by ltaoj on 2017/9/20.
 */
public class Register {
    private Signon signon;
    private String repeatPassword;
    private String code;

    public Signon getSignon() {
        return signon;
    }

    public void setSignon(Signon signon) {
        this.signon = signon;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
