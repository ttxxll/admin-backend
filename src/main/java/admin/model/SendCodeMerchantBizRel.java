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
 * 商户授权业务关系表
 * </p>
 *
 * @author no
 * @since 2025-07-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_code_merchant_biz_rel")
public class SendCodeMerchantBizRel implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商户ID
     */
    private Long merchantId;

    /**
     * 账户名
     */
    private String account;

    /**
     * 授权业务编码
     */
    private String bizCode;

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

    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

    private Date createTime;

    private Date updateTime;


}
