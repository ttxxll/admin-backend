package admin.controller;


import admin.common.BaseResult;
import admin.controller.req.recharge.RechargeRecordAddReq;
import admin.controller.req.recharge.RechargeRecordPageReq;
import admin.controller.req.recharge.RechargeRecordUpdateReq;
import admin.dto.PageDto;
import admin.model.RechargeRecord;
import admin.service.RechargeRecordService;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发码充值记录 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/recharge")
public class RechargeRecordController {

    @Autowired
    private RechargeRecordService rechargeRecordService;

    @PostMapping("/page")
    public BaseResult rechargeRecordPage(@RequestBody RechargeRecordPageReq pageReq) {
        try {
            log.info("rechargeRecordPage begin! req = {}", JsonUtil.obj2Json(pageReq));
            PageDto<RechargeRecord> pageResult = rechargeRecordService.rechargeRecordPage(pageReq);
            return BaseResult.buildSuccess(pageResult);
        } catch (Exception e) {
            log.error("rechargeRecordPage page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/add")
    public BaseResult addRechargeRecord(@RequestBody RechargeRecordAddReq addReq) {
        try {
            log.info("addRechargeRecord begin! req = {}", JsonUtil.obj2Json(addReq));
            BaseResult baseResult = rechargeRecordService.addRechargeRecord(addReq);
            return baseResult;
        } catch (Exception e) {
            log.error("addRechargeRecord page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }

    @PostMapping("/update")
    public BaseResult updateRechargeRecord(@RequestBody RechargeRecordUpdateReq updateReq) {
        try {
            log.info("updateRechargeRecord begin! req = {}", JsonUtil.obj2Json(updateReq));
            BaseResult baseResult = rechargeRecordService.updateRechargeRecord(updateReq);
            return baseResult;
        } catch (Exception e) {
            log.error("updateRechargeRecord page error!", e);
            return BaseResult.buildError(e.getMessage());
        }
    }
}

