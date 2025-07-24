package admin.controller.req.platform;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-24 16:33
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SendCodePlatformPageReq extends SendCodePlatformBase {
    private Integer page;
    private Integer size;
}
