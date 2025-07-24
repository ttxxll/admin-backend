package admin.controller.req.recharge;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-24 11:36
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RechargeRecordPageReq extends RechargeRecordBase {
    private Integer page;
    private Integer size;
}
