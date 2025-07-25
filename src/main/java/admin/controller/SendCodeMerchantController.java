package admin.controller;


import admin.common.BaseResult;
import admin.controller.req.merchant.SendCodeMerchantAddReq;
import admin.controller.req.merchant.SendCodeMerchantPageReq;
import admin.controller.req.merchant.SendCodeMerchantUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeMerchantInfo;
import admin.service.SendCodeMerchantInfoService;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发码业务商户信息 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/merchant")
public class SendCodeMerchantController {

    @Autowired
    private SendCodeMerchantInfoService sendCodeMerchantInfoService;

    @PostMapping("/page")
    public BaseResult sendCodeMerchantPage(@RequestBody SendCodeMerchantPageReq pageReq) {
        try {
            log.info("sendCodeMerchantPage begin! req = {}", JsonUtil.obj2Json(pageReq));
            PageDto<SendCodeMerchantInfo> pageResult = sendCodeMerchantInfoService.pageQuery(pageReq);
            return BaseResult.buildSuccess(pageResult);
        } catch (Exception e) {
            log.error("sendCodeMerchantPage page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/add")
    public BaseResult addSendCodeMerchant(@RequestBody SendCodeMerchantAddReq addReq) {
        try {
            log.info("addSendCodeMerchant begin! req = {}", JsonUtil.obj2Json(addReq));
            BaseResult baseResult = sendCodeMerchantInfoService.addSendCode(addReq);
            return baseResult;
        } catch (Exception e) {
            log.error("addSendCodeMerchant page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/update")
    public BaseResult updateSendCodeMerchant(@RequestBody SendCodeMerchantUpdateReq updateReq) {
        try {
            log.info("updateSendCodeMerchant begin! req = {}", JsonUtil.obj2Json(updateReq));
            BaseResult baseResult = sendCodeMerchantInfoService.updateSendCode(updateReq);
            return baseResult;
        } catch (Exception e) {
            log.error("updateSendCodeMerchant page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

}

