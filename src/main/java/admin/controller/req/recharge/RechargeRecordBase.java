package admin.controller.req.recharge;

import lombok.Data;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-24 11:36
 */
@Data
public class RechargeRecordBase {

    private Integer rechargeQuantity;

    private Long merchantId;

    private String account;

    private String bizCode;

    private String bizName;

    private String sendPlatformCode;

    private String sendPlatformName;
}
