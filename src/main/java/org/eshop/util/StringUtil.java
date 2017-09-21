package org.eshop.util;

import java.util.Date;
import java.util.Random;

/**
 * Created by ltaoj on 2017/9/21.
 */
public class StringUtil {

    // 订单id格式：20170501123342FED6YH
    public static String createOrderId(Date date) {
        StringBuffer sb = new StringBuffer();
        sb.append(date.getYear() + date.getMonth() + date.getDay() + date.getHours() + date.getMinutes() + date.getSeconds() + getRandomString(6));
        return sb.toString();
    }

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String base = "ABCDEFGHIGKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
