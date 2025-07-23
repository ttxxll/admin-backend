package admin.controller;


import admin.common.BaseResult;
import admin.controller.req.SendCodeMerchantAddReq;
import admin.controller.req.SendCodeMerchantPageReq;
import admin.controller.req.SendCodeMerchantUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeMerchantInfo;
import admin.service.SendCodeBizInfoService;
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
 * 发码业务信息 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/codeBiz")
public class SendCodeBizController {

    @Autowired
    private SendCodeBizInfoService sendCodeBizInfoService;

    @PostMapping("/page")
    public BaseResult sendCodeBizPage(@RequestBody SendCodeMerchantPageReq pageReq) {
        try {
            log.info("sendCodeBizPage begin! req = {}", JsonUtil.obj2Json(pageReq));
            PageDto<SendCodeMerchantInfo> pageResult = sendCodeBizInfoService.pageQuery(pageReq);
            return BaseResult.buildSuccess(pageResult);
        } catch (Exception e) {
            log.error("sendCodeBizPage page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/add")
    public BaseResult addSendCodeBiz(@RequestBody SendCodeMerchantAddReq addReq) {
        try {
            log.info("addSendCodeBiz begin! req = {}", JsonUtil.obj2Json(addReq));
            BaseResult baseResult = sendCodeBizInfoService.addSendCodeBiz(addReq);
            return baseResult;
        } catch (Exception e) {
            log.error("addSendCodeBiz page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/update")
    public BaseResult updateSendCodeBiz(@RequestBody SendCodeMerchantUpdateReq updateReq) {
        try {
            log.info("updateSendCodeBiz begin! req = {}", JsonUtil.obj2Json(updateReq));
            BaseResult baseResult = sendCodeBizInfoService.updateSendCodeBiz(updateReq);
            return baseResult;
        } catch (Exception e) {
            log.error("updateSendCodeBiz page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }
}

