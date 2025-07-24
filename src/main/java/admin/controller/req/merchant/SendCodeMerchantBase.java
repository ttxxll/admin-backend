package admin.controller.req.merchant;

import lombok.Data;

@Data
public class SendCodeMerchantBase {
    private String account;
    private Integer agentLevel;
    private String agentBelong;
    private Integer weight;
    private Integer bizPermissionType;
    private Integer status;
    private String bizList;

}
