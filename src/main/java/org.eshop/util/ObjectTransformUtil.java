package org.eshop.util;

import org.eshop.entity.Signon;
import org.eshop.entity.Userinfo;

/**
 * Created by ltaoj on 2017/9/18.
 * 转换对象
 */
public class ObjectTransformUtil {
    public static Userinfo toUserinfo(Signon signon) {
        Userinfo userinfo = new Userinfo();
        userinfo.setLoginId(signon.getUserId());
        userinfo.setEmail(signon.getEmail());
        userinfo.setPhone(signon.getPhone());
        return userinfo;
    }
}
