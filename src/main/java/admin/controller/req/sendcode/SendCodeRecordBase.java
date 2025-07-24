package admin.controller.req.sendcode;

import lombok.Data;

import java.util.Date;

@Data
public class SendCodeRecordBase {

    private String issuedCode;

    private String issuedPhone;

    private Long bizId;

    private String bizCode;

    private String bizName;

    private Long merchantId;

    private String account;

    private String sendPlatformCode;

    private String sendPlatformName;

    private Integer status;

    private Date updateTime;

    private Date createTime;

}
