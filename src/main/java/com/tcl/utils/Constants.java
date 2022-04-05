package com.tcl.utils;

/**
 * Created by wang on 2017-06-13.
 */
public class Constants {

    public static final String PASSPORT_COOKIE_NAME_C = "tclapp_c";
    public static final String PASSPORT_COOKIE_NAME_D = "tclapp_d";


    //订单状态
    public final static int TRADE_STATUS_PREORDER = -2;//订单状态 未预约
    public final static int TRADE_STATUS_ORDER = -1;//订单状态 已预约
    public final static int TRADE_STATUS_DEFAULT = 0;//订单状态 已下单
    public final static int TRADE_STATUS_PAID = 1;//订单状态 已付款
    public final static int TRADE_STATUS_ADVICE = 2;//订单状态 2已开医嘱
    public final static int TRADE_STATUS_COLLECTION = 3;//订单状态 3已采集
    public final static int TRADE_STATUS_TEST = 4;//订单状态 4检验中
    public final static int TRADE_STATUS_REPORT = 5;//订单状态 已报告
    public final static int TRADE_STATUS_UNSCRAMBLE = 6;//订单状态 已解读

    //用户状态
    public final static String User_STATUS_DEFAULT = "0";//用户状态 初始化 未验证
    public final static String USER_STATUS_USE = "1";//用户状态 使用中
    public final static String USER_STATUS_AUDIT = "2";//用户状态 待审核
    public final static String USER_STATUS_FAult = "3";//用户状态 失败
    public final static String USER_STATUS_PAUSED = "-1";//用户状态 已暂停

    //联系人是否默认
    public static final int APPLICANT_IS_NOT_DEFAULT=0;//联系人 非默认
    public static final int APPLICANT_IS_DEFAULT=1;//联系人 默认

    //用户请求返回状态码
    public static final int REQUEST_SUCCESS=200;//请求成功
    public static final int REQUEST_FAIL=-1;//请求失败

    //医生类别
    public static final int DOCTOR_TYPE_DOCTOR=1;//医生类别 中心医生
    public static final int DOCTOR_TYPE_NURSE=2;//医生类别 护士
    public static final int DOCTOR_TYPE_JIEDU=3;//医生类别 解读医生
    // 日志
    public static final int LOG_MODE=1;

    //推送类型 type
    public static final String PUSH_TYPE_PAY="1";//客户已付款,通知开单医生（医生端）
    public static final String PUSH_TYPE_DOCTORORDER="2";//客户已付款 医生下单
    public static final String PUSH_TYPE_GATHER="3";// 通知用户 采集时间，采集地点（用户端）
    public static final String PUSH_TYPE_HASTAKED="4"; //通知用户，套餐已采集完毕（用户端）
    public static final String PUSH_TYPE_JIEDU="5"; //通知用户，报告已解读（用户端）
    public static final String PUSH_TYPE_MAKE="6";//医生给客户预约订单的通知（用户端）
    public static final String PUSH_TYPE_CHART_RECOMMEND="7";//聊天推荐，通知用户医生推荐了套餐（用户端）




    /**支付宝公钥-从支付宝生活号详情页面获取*/
    public static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlk2OUt//IHqEoWuTl9VTYpIzfba0kYvOFwXFhcF1kjJYi1Erp+BJIpCVz2ZkPlEmNSHJZelSMjoz/ATS/cRsqIr4049RmlsUWnAsEtsW/qCh9gXwFVzdwDUCQjrUF7ZNGQFQxijgmrny0VmRRwilZ9Qlfpj5hRh6/B7XUH6jSGzDodvhUrvUbgAgStjBCAfJeuAg8VmnY7i0q1HH+2BlNopwPm/4H2g0OwypQlvyaVwbV5Wp/kHMrVY07CKOjJkZ760cUPFXnL6NG6LYfwm2gkYwLf2f7xK9pNzPCt6Gw6N88+N4S4SvbbwDoNOq2DTKhvETryFNzGd1fB431zs92wIDAQAB";

    /**签名编码-视支付宝服务窗要求*/
    public static final String SIGN_CHARSET      = "GBK";

    /**字符编码-传递给支付宝的数据编码*/
    public static final String CHARSET           = "GBK";

    /**签名类型-视支付宝服务窗要求*/
    public static final String SIGN_TYPE         = "RSA2";

    /**开发者账号PID*/
    public static final String PARTNER           = "2088702218146924";

    /** 服务窗appId  */
    //TODO !!!! 注：该appId必须设为开发者自己的生活号id
    public static final String APP_ID            = "2016022601166432";

    //TODO !!!! 注：该私钥为测试账号私钥  开发者必须设置自己的私钥 , 否则会存在安全隐患
    public static final String PRIVATE_KEY       = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCXN7VXirHsUogyD5ld/yNPIz9uGsO3nucGfKQ7XnLk6PlKCnLz8SeU4L+ZQzC3+drOEQYRKCSG7HyLc1abUE0j5HSOW8G9xpDawkep8xpC6RHGMRZc/BiNPJ2mpnjl3TOhXRKXaSHjLFcxZ6nVVl/MgUushgSEzpuQanUMHu6rP2Xkaz/UxguA70szENS96/ijRIc28UADqmOUHHBYIg1irMEZk3wkRBJXZPx7lrLVjffM5dXCglb9X3S2r6QBxGvUKhRshYDX9CT/eOpz5OqntktXorzEoHHT2TCC5KoouWZwbn+N9UzMmvSqRIADFmwTGFBiG7JbpzSt9qJ72W0RAgMBAAECggEAe6F7LIhjcRAE89DXFgd7ib8Ko+1T6HMM9LvA1h0hGE/1SHiEhTa7orehTh+l3DR1lJZMfIhyXLFKHgT9YNvlRZwJQz53hr2qPoAqcSMlbGD7PCtz2i/trsNJLS/bliskhCABDDNTFlVxMB5NtvL4Pc3T3chwN1hnzUmMSo2bmftlk5aoAaWOXgnclHfpkui5fbCCBtHSDX76RZsf4eWthoTMtmVxIPlRNOMQqxcsHVOB//WKhJ72unZS5Z3kkudHPX5aiNjWLbzeOY7rq/kpga89jv9MaXF8w3JJP8XOe10tdA6FbGZ7ndf0Gkq/S/hbrXrDPtP3c3+4K7KEh5IeJQKBgQDhYWeASUl0Tl7aetris2pwCaBMmwmVhB4gSVxJO3TfCVUD2nnxKdfqVQxsLI28Qkdd9plrfcXyB811vAyRrV+0gQxYkJwybO8va6KmYsXORiGUr4TkklfWqNAy7mcDQJsnZ8Pkmpx/Zv/gLRHiVRix5jazhVZu4HAFFI7nG7oU2wKBgQCrwvbtL5UvzYRkeixZ9s93pYE80wg2jHs2QpaUJXl7rBQc69dDNqZDYCDbRZl+7oPD0oHRuMIN7ep+ZOCgxr8N544ggLEK7IWSy06DRehYZChI3vipYAWojkx5TR1kZNqo//Ycjcy4t4rkn64Otum29LJnjHk/TGqD+6SvqiWTgwKBgQDJvo8PXorJ+X0exOo6E7ArKfK7n+wsUl9FN2XMh9RN8eSP1nlhTrtfn1HHYvpcklef3KXoemU+CY343aPCoxcQVJPgk1G+MZTJNegaWEAILO7SUWr7z6OhGuuDK7Q6TRKVa2UGtP9xa5mP6cggeVvpotFEUQ7VoUGkyopAhalEEQKBgQCEElk+jjz/0d7AR/U8g/yJepjChV6mWyUO1urkJWChSPL6Php601XLLup00LKzmIF3HLG36oJEpbGO2NCkr84OygNOWMZJqQ8Yjf3kEOgUt4cGaXT5AB25uxlwmGxGWwqLsq2yzRIi4vcIzwPOyrUxejyIRMqicobgz6mVbZaRMwKBgAoMcMe74hI2bx87edMTfo/1gPz6rkZ5NY34XO8Qn+wEe5ULSCdQ52Q/m/vMvncFz4NtgrWbEy44/s2BOpXMl3A7sIL+O9EnAFAq6pGsqz6F0fR7AKEc3XPPGa46e/sKo1xAPlLtt6cAv4AubBznptrSgeIJr5DS3F1nZ2HGLo09";

    //TODO !!!! 注：该公钥为测试账号公钥  开发者必须设置自己的公钥 ,否则会存在安全隐患
    public static final String PUBLIC_KEY        = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlze1V4qx7FKIMg+ZXf8jTyM/bhrDt57nBnykO15y5Oj5Sgpy8/EnlOC/mUMwt/nazhEGESgkhux8i3NWm1BNI+R0jlvBvcaQ2sJHqfMaQukRxjEWXPwYjTydpqZ45d0zoV0Sl2kh4yxXMWep1VZfzIFLrIYEhM6bkGp1DB7uqz9l5Gs/1MYLgO9LMxDUvev4o0SHNvFAA6pjlBxwWCINYqzBGZN8JEQSV2T8e5ay1Y33zOXVwoJW/V90tq+kAcRr1CoUbIWA1/Qk/3jqc+Tqp7ZLV6K8xKBx09kwguSqKLlmcG5/jfVMzJr0qkSAAxZsExhQYhuyW6c0rfaie9ltEQIDAQAB";
    /**支付宝网关*/
    public static final String ALIPAY_GATEWAY    = "https://openapi.alipay.com/gateway.do";
    /**支付宝 回调地址*/
    public static final String ALIPAY_BACK    ="http://112.17.95.125:9099/alipay/alipayBack.do";//"http://183.247.179.221:9098/alipayBack.do";//

    /**授权访问令牌的授权类型*/
    public static final String GRANT_TYPE        = "authorization_code";


    /**微信 回调地址*/
    public static final String WXPAY_BACK    ="http://112.17.95.125:9099/wxpay/wxpayBack.do";//"http://183.247.179.221:9098/alipayBack.do";//

}
