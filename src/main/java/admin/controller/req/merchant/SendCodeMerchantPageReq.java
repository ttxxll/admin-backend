package admin.controller.req.merchant;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendCodeMerchantPageReq extends SendCodeMerchantBase {
    private Integer page;
    private Integer size;
}
