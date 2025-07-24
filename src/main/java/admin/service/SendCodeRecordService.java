package admin.service;

import admin.common.BaseResult;
import admin.controller.req.sendcode.SendCodeRecordAddReq;
import admin.controller.req.sendcode.SendCodeRecordPageReq;
import admin.controller.req.sendcode.SendCodeRecordUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeRecord;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 下发编码记录 服务类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
public interface SendCodeRecordService extends IService<SendCodeRecord> {

    PageDto<SendCodeRecord> sendCodeRecordPage(SendCodeRecordPageReq pageReq);

    BaseResult addSendCodeRecord(SendCodeRecordAddReq addReq);

    BaseResult updateSendCodeRecord(SendCodeRecordUpdateReq updateReq);
}
