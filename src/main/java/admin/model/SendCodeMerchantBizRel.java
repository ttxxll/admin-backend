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
 * 商户授权业务关系表
 * </p>
 *
 * @author no
 * @since 2025-07-22
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
     * 授权业务编码
     */
    private String bizCode;

    private Date createTime;

    private Date updateTime;


}
