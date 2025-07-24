package admin.controller;

import admin.common.BaseResult;
import admin.controller.req.sendcode.SendCodeRecordAddReq;
import admin.controller.req.sendcode.SendCodeRecordPageReq;
import admin.controller.req.sendcode.SendCodeRecordUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeRecord;
import admin.service.SendCodeRecordService;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 下发编码记录 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/sendCode")
public class SendCodeRecordController {

    @Autowired
    private SendCodeRecordService sendCodeRecordService;

    @PostMapping("/page")
    public BaseResult sendCodeRecordPage(@RequestBody SendCodeRecordPageReq pageReq) {
        try {
            log.info("sendCodeRecordPage begin! req = {}", JsonUtil.obj2Json(pageReq));
            PageDto<SendCodeRecord> pageResult = sendCodeRecordService.sendCodeRecordPage(pageReq);
            return BaseResult.buildSuccess(pageResult);
        } catch (Exception e) {
            log.error("sendCodeRecordPage page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/add")
    public BaseResult addSendCodeRecord(@RequestBody SendCodeRecordAddReq addReq) {
        try {
            log.info("addSendCodeRecord begin! req = {}", JsonUtil.obj2Json(addReq));
            BaseResult baseResult = sendCodeRecordService.addSendCodeRecord(addReq);
            return baseResult;
        } catch (Exception e) {
            log.error("addSendCodeRecord page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/update")
    public BaseResult updateSendCodeRecord(@RequestBody SendCodeRecordUpdateReq updateReq) {
        try {
            log.info("updateSendCodeRecord begin! req = {}", JsonUtil.obj2Json(updateReq));
            BaseResult baseResult = sendCodeRecordService.updateSendCodeRecord(updateReq);
            return baseResult;
        } catch (Exception e) {
            log.error("updateSendCodeRecord page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }
}

