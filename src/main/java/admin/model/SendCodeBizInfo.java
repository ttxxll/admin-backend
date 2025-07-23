package admin.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 发码业务信息
 * </p>
 *
 * @author no
 * @since 2025-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_code_biz_info")
public class SendCodeBizInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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

    private Date updateTime;

    private Date createTime;


}
