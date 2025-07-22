package admin.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 发码充值记录
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("recharge_record")
public class RechargeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 充值数量
     */
    private Integer rechargeQuantity;

    /**
     * 商户id
     */
    private Long merchantId;

    /**
     * 账户名
     */
    private String account;

    /**
     * 业务编码
     */
    private String bizCode;

    /**
     * 业务名称
     */
    private String bizName;

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
