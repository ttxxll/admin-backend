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

    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;
}
