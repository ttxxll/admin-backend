package admin.controller;

import admin.common.BaseResult;
import admin.controller.req.platform.SendCodePlatformAddReq;
import admin.controller.req.platform.SendCodePlatformPageReq;
import admin.controller.req.platform.SendCodePlatformUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodePlatformInfo;
import admin.service.SendCodePlatformService;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 下发编码平台 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/codePlatform")
public class SendCodePlatformController {

    @Autowired
    private SendCodePlatformService platformService;

    @PostMapping("/page")
    public BaseResult codePlatformPage(@RequestBody SendCodePlatformPageReq pageReq) {
        try {
            log.info("codePlatformPage begin! req = {}", JsonUtil.obj2Json(pageReq));
            PageDto<SendCodePlatformInfo> pageResult = platformService.codePlatformPage(pageReq);
            return BaseResult.buildSuccess(pageResult);
        } catch (Exception e) {
            log.error("codePlatformPage page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/add")
    public BaseResult addCodePlatform(@RequestBody SendCodePlatformAddReq addReq) {
        try {
            log.info("addCodePlatform begin! req = {}", JsonUtil.obj2Json(addReq));
            BaseResult baseResult = platformService.addCodePlatform(addReq);
            return baseResult;
        } catch (Exception e) {
            log.error("addCodePlatform page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/update")
    public BaseResult updateCodePlatform(@RequestBody SendCodePlatformUpdateReq updateReq) {
        try {
            log.info("updateCodePlatform begin! req = {}", JsonUtil.obj2Json(updateReq));
            BaseResult baseResult = platformService.updateCodePlatform(updateReq);
            return baseResult;
        } catch (Exception e) {
            log.error("updateCodePlatform page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }
}

