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
 * 发码业务商户信息
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("send_code_merchant_info")
public class SendCodeMerchantInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 账户名
     */
    private String account;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 账户代理等级
     */
    private Integer agentLevel;

    /**
     * 所属代理
     */
    private String agentBelong;

    /**
     * 权重
     */
    private Integer weight;

    /**
     * 业务权限类型：-1无权限，0部分权限，1所有权限
     */
    private Integer bizPermissionType;

    /**
     * 授权业务列表
     */
    private String bizList;

    /**
     * 角色列表
     */
    private String roles;

    /**
     * 头像
     */
    private String avatar;

    /**
     * IP白名单（多个IP用逗号分隔）
     */
    private String ipWhitelist;

    /**
     * 状态：0-禁用，1-启用
     */
    private Integer status;

    private Date updateTime;

    private Date createTime;


}
