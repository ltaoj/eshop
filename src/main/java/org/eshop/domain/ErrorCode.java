package org.eshop.domain;

/**
 * Created by ltaoj on 2017/9/20.
 */
public class ErrorCode {
    public static final int SEND_EMAIL_CODE_ERROR = 1; // 邮箱验证码获取错误
    public static final int EMAIL_CODE_INVALID = 2; // 邮箱验证码不匹配
    public static final int REGIST_FAILED_ERROR = 3; // 注册失败
    public static final int GET_USERINFO_FAILEED = 4; // 获取用户信息失败
    public static final int ADD_ADDRESS_FAILED = 5; // 收获地址添加失败
    public static final int DEL_ADDRESS_FAILED = 6; // 删除收获地址失败
    public static final int GET_ADDRESS_FAILED = 7; // 获取收获地址列表
    public static final int UPDATE_ADDRESS_FAILED = 8; // 收货地址信息更新失败
    public static final int DEFAULT_ADDRESS_SETTING_FAILED = 9; // 默认收货地址修改失败
    public static final int ORIGIN_PASSWORD_UNCORRECT = 10; // 原密码不正确
    public static final int CHANGE_PASSWORD_FAILED = 11; // 修改密码失败
    public static final int UPDATE_USERINFO_FAILED = 12; // 基本信息修改失败
    public static final int SEARCH_ITEM_ERROR = 13; // 商品搜索错误
    public static final int GET_ITEM_DETAIL_FAILED = 14; // 商品详细信息获取错误
    public static final int ADD_IETM_TO_CART_FAILED = 15; // 商品添加购物车失败
    public static final int REMOVE_FROM_CART_FAILED = 16; // 移除购物车商品失败
    public static final int CARTITEM_STEP_FAILED = 17; // 购物车商品数量递增递减失败
    public static final int VIEWCART_FAILED = 18; // 查看购物车失败
    public static final int CREATE_ORDER_FAILED = 19; // 订单创建失败
    public static final int GET_ORDER_DETAIL_FAILED = 20; // 订单详情查询失败
    public static final int GET_ORDER_LIST_FAILED = 21; // 订单列表获取失败
    public static final int CANCEL_ORDER_FAILED = 22; // 订单取消失败
    public static final int DELETE_ORDER_FAILED = 23; // 订单删除失败
}
