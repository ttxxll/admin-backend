package admin.controller.req.codebiz;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SendCodeBizInfoBase {

    /**
     * 业务编码
     */
    private String bizCode;

    /**
     * 业务名称
     */
    private String bizName;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 账户名
     */
    private String account;

    /**
     * 总数量
     */
    private Integer quantity;

    /**
     * 已使用数量
     */
    private Integer usedQuantity;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 发送平台编码
     */
    private String sendPlatformCode;

    /**
     * 发送平台名称
     */
    private String sendPlatformName;
}
