package admin.service;

import admin.common.BaseResult;
import admin.controller.req.recharge.RechargeRecordAddReq;
import admin.controller.req.recharge.RechargeRecordPageReq;
import admin.controller.req.recharge.RechargeRecordUpdateReq;
import admin.dto.PageDto;
import admin.model.RechargeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 发码充值记录 服务类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
public interface RechargeRecordService extends IService<RechargeRecord> {

    PageDto<RechargeRecord> rechargeRecordPage(RechargeRecordPageReq pageReq);

    BaseResult addRechargeRecord(RechargeRecordAddReq addReq);

    BaseResult updateRechargeRecord(RechargeRecordUpdateReq updateReq);
}
