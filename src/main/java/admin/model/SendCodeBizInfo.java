package admin.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 发码业务信息
 * </p>
 *
 * @author no
 * @since 2025-07-22
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
     * 商户id
     */
    private Long merchantId;

    /**
     * 账户名
     */
    private String account;

    /**
     * 总数量
     */
    private Integer quantity;

    /**
     * 已使用数量
     */
    private Integer usedQuantity;

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

    private Date updateTime;

    private Date createTime;


}
