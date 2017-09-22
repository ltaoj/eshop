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
}
