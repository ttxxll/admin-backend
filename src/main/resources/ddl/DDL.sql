CREATE TABLE `send_code_merchant_info` (
   `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `account` VARCHAR(128) NOT NULL COMMENT '账户名',
   `pwd` VARCHAR(128) NOT NULL COMMENT '密码',
   `agent_level` TINYINT NOT NULL DEFAULT 0 COMMENT '账户代理等级',
   `agent_belong` VARCHAR(256) NOT NULL COMMENT '所属代理',
   `weight` INT NOT NULL DEFAULT 0 COMMENT '权重',
   `biz_permission_type` TINYINT DEFAULT -1 COMMENT '业务权限类型：-1无权限，0部分权限，1所有权限',
   `biz_list` JSON DEFAULT NULL COMMENT '授权业务列表',
   `ip_whitelist` VARCHAR(512) COMMENT 'IP白名单（多个IP用逗号分隔）',
   `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-禁用，1-启用',
   `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `idx_account` (`account`) COMMENT '账户名唯一索引'
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='发码业务商户信息';

DROP TABLE IF EXISTS `send_code_biz_info`;
CREATE TABLE `send_code_biz_info` (
  `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `biz_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '业务编码',
  `biz_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '业务名称',
  `unit_price` DECIMAL(5, 2) NOT NULL DEFAULT 0.00 COMMENT '单价',
  `send_platform_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送平台编码',
  `send_platform_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '发送平台名称',
  `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-禁用，1-启用',
  `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_biz` (`biz_code`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='发码业务信息';


DROP TABLE IF EXISTS `send_code_merchant_biz_rel`;
CREATE TABLE `send_code_merchant_biz_rel` (
      `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
      `merchant_id` BIGINT UNSIGNED NOT NULL COMMENT '商户ID',
      `account` VARCHAR(128) NOT NULL COMMENT '账户名',
      `biz_code` VARCHAR(32) NOT NULL COMMENT '授权业务编码',
      `quantity` INT NOT NULL DEFAULT 0 COMMENT '总数量',
      `used_quantity` INT NOT NULL DEFAULT 0 COMMENT '已使用数量',
      `unit_price` DECIMAL(5, 2) NOT NULL DEFAULT 0.00 COMMENT '单价',
      `send_platform_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送平台编码',
      `send_platform_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '发送平台名称',
      `status` TINYINT NOT NULL DEFAULT 0 COMMENT '状态：0-禁用，1-启用',
      `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
      `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
      PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商户授权业务关系表';


CREATE TABLE `send_code_record` (
    `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
    `issued_code` VARCHAR(11) NOT NULL DEFAULT '' COMMENT '下发编码',
    `issued_phone` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '下发手机',
    `biz_id` BIGINT NOT NULL COMMENT '业务id',
    `biz_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '业务编码',
    `biz_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '业务名称',
    `merchant_id` BIGINT UNSIGNED NOT NULL COMMENT '商户id',
    `account` VARCHAR(128) NOT NULL COMMENT '冗余账户名',
    `send_platform_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送平台编码',
    `send_platform_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '发送平台名称',
    `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_biz_id` (`biz_id`),
    KEY `idx_issued_code` (`issued_code`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='下发编码记录';


CREATE TABLE `send_code_platform_info` (
   `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `send_platform_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送平台编码',
   `send_platform_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '发送平台名称',
   `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   UNIQUE KEY `uk_platform_code` (`send_platform_code`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='下发编码平台';


CREATE TABLE `recharge_record` (
   `id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
   `recharge_quantity` INT NOT NULL DEFAULT 0 COMMENT '充值数量',
   `merchant_id` BIGINT UNSIGNED NOT NULL COMMENT '商户id',
   `account` VARCHAR(128) NOT NULL COMMENT '账户名',
   `biz_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '业务编码',
   `biz_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '业务名称',
   `send_platform_code` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送平台编码',
   `send_platform_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '发送平台名称',
   `update_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`),
   KEY `idx_merchant_id` (`merchant_id`),
   KEY `idx_account` (`account`)
)ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='发码充值记录';