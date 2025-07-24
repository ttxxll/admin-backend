package admin.controller.req.platform;

import lombok.Data;

import java.util.Date;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-24 16:23
 */
@Data
public class SendCodePlatformBase {

    /**
     * 发送平台编码
     */
    private String sendPlatformCode;

    /**
     * 发送平台名称
     */
    private String sendPlatformName;

    private Integer status;

    private Date updateTime;

    private Date createTime;

}
