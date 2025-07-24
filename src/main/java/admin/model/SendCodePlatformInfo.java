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
 * 下发编码平台
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_code_platform_info")
public class SendCodePlatformInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
