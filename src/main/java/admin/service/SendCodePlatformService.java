package admin.service;

import admin.common.BaseResult;
import admin.controller.req.platform.SendCodePlatformAddReq;
import admin.controller.req.platform.SendCodePlatformPageReq;
import admin.controller.req.platform.SendCodePlatformUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodePlatformInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 下发编码平台 服务类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
public interface SendCodePlatformService extends IService<SendCodePlatformInfo> {

    PageDto<SendCodePlatformInfo> codePlatformPage(SendCodePlatformPageReq pageReq);

    BaseResult addCodePlatform(SendCodePlatformAddReq addReq);

    BaseResult updateCodePlatform(SendCodePlatformUpdateReq updateReq);
}
