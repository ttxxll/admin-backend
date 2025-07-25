package admin.enums;

import lombok.Getter;

/**
 * @author taoxinglong
 * @description 统一业务状态码：共6位，前3位代表服务，后三位代表接口
 * @date 2023-11-19 15:56
 */
public enum BizCodeEnum {


    /**
     * 短链分组
     */
    GROUP_REPEAT(23001,"分组名重复"),
    GROUP_OPER_FAIL(23503,"分组名操作失败"),
    GROUP_NOT_EXIST(23404,"分组不存在"),
    GROUP_ADD_FAILED(23405,"分组添加失败"),



    /**
     *验证码
     */
    CODE_TO_ERROR(240001,"接收号码不合规"),
    CODE_LIMITED(240002,"验证码发送过快"),
    CODE_ERROR(240003,"验证码错误"),
    CODE_CAPTCHA_ERROR(240104,"图形验证码错误"),
    CODE_CAPTCHA_EXPIRED(240105,"图形验证码过期"),



    /**
     * 账号
     */
    ACCOUNT_REPEAT(250001,"账号已经存在"),
    ACCOUNT_UNREGISTER(250002,"账号不存在"),
    ACCOUNT_PWD_ERROR(250003,"账号或者密码错误"),
    ACCOUNT_UNLOGIN(250004,"账号未登录"),
    ACCOUNT_DATA_ERROR(250005,"账号数据异常"),


    /**
     * 短链
     */
    SHORT_LINK_NOT_EXIST(260404,"短链不存在"),


    /**
     * 订单
     */
    ORDER_CONFIRM_PRICE_FAIL(280002,"创建订单-验价失败"),
    ORDER_CONFIRM_REPEAT(280008,"订单恶意重复提交"),
    ORDER_CONFIRM_TOKEN_EQUAL_FAIL(280009,"订单令牌缺少"),
    ORDER_CONFIRM_NOT_EXIST(280010,"订单不存在"),

    /**
     * 支付
     */
    PAY_ORDER_FAIL(300001,"创建支付订单失败"),
    PAY_ORDER_CALLBACK_SIGN_FAIL(300002,"支付订单回调验证签失败"),
    PAY_ORDER_CALLBACK_NOT_SUCCESS(300003,"支付回调处理失败"),
    PAY_ORDER_CALLBACK_MSG_DUP(300004,"支付回调处理消息已发送"),
    PAY_ORDER_NOT_EXIST(300005,"订单不存在"),
    PAY_ORDER_STATE_ERROR(300006,"订单状态不正常"),
    PAY_ORDER_PAY_TIMEOUT(300007,"订单支付超时"),


    /**
     * 流控操作
     */
    CONTROL_FLOW(500101,"限流控制"),
    CONTROL_DEGRADE(500201,"降级控制"),
    CONTROL_AUTH(500301,"认证控制"),


    /**
     * 流量包操作
     */
    TRAFFIC_FREE_NOT_EXIST(600101,"免费流量包不存在，联系客服"),

    TRAFFIC_REDUCE_FAIL(600102,"流量不足，扣减失败"),

    TRAFFIC_EXCEPTION(600103,"流量包数据异常,用户无流量包"),


    /**
     * 通用操作码
     */

    OPS_REPEAT(110001,"重复操作"),
    OPS_NETWORK_ADDRESS_ERROR(110002,"网络地址错误"),


    /**
     * 文件相关
     */
    FILE_UPLOAD_USER_IMG_FAIL(700101,"用户头像文件上传失败"),

    /**
     * 数据库相关
     */
    DB_ROUTE_NOT_FOUND(800101, "数据源路由失败"),

    /**
     * MQ相关
     */
    MQ_CONSUME_EXCEPTION(900100, "队列消费异常"),

    MQ_ADD_LINK_CONSUMER_EXCEPTION(900101, "Link新增队列消费异常"),

    MQ_ADD_MAPPING_CONSUMER_EXCEPTION(900102, "Mapping新增队列消费异常"),

    MQ_DEL_LINK_CONSUMER_EXCEPTION(900103, "Link删除队列消费异常"),

    MQ_DEL_MAPPING_CONSUMER_EXCEPTION(900104, "Mapping删除队列消费异常"),

    MQ_UPDATE_LINK_CONSUMER_EXCEPTION(900105, "Link更新队列消费异常"),

    MQ_UPDATE_MAPPING_CONSUMER_EXCEPTION(900106, "Mapping更新队列消费异常"),

    MQ_ORDER_CLOSE_CONSUMER_EXCEPTION(900107, "订单关闭队列消费异常"),

    /**
     * 数据查询条数超过限制
     */
    DATA_OUT_OF_LIMIT_SIZE(400001,"查询条数超过限制") ,

    /**
     * 数据查询超过最大跨度
     */
    DATA_OUT_OF_LIMIT_DATE(400002,"日期查询超过最大跨度");

    @Getter
    private String message;

    @Getter
    private int code;

    private BizCodeEnum(int code, String message){
        this.code = code;
        this.message = message;
    }
}
