package admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 下发编码记录
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_code_record")
public class SendCodeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 下发编码
     */
    private String issuedCode;

    /**
     * 下发手机
     */
    private String issuedPhone;

    /**
     * 业务id
     */
    private Long bizId;

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
     * 冗余账户名
     */
    private String account;

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
