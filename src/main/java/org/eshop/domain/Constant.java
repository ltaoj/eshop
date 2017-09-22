package org.eshop.domain;

/**
 * Created by ltaoj on 2017/9/21.
 */
public class Constant {
    public static final int UNUSE_ADDR_AS_DEFAULT = 0; // 不是默认地址
    public static final int USE_ADDR_AS_DEFAULT = 1; // 默认地址

    public static final int ORDER_UNPAIED = 0; // 订单未付款
    public static final int ORDER_CANCELED = 1; // 订单取消

    public static final String SEARCH_BY_NAME = "name"; // 通过商品名称搜索
    public static final String SEARCH_BY_ATTR_COLOR = "color"; // 通过颜色属性搜索
    public static final String SEARCH_BY_ATTR_SHAPE = "shape"; // 通过形状属性搜索

    public static final int ORDER_UNPAY_STATUS = 0; // 订单未支付
    public static final int ORDER_CANCEL_STATUS = 1; // 订单取消
}
