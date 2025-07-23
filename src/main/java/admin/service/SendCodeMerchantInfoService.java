package admin.service;

import admin.common.BaseResult;
import admin.controller.req.SendCodeMerchantAddReq;
import admin.controller.req.SendCodeMerchantPageReq;
import admin.controller.req.SendCodeMerchantUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeMerchantInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 发码业务商户信息 服务类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
public interface SendCodeMerchantInfoService extends IService<SendCodeMerchantInfo> {

    PageDto<SendCodeMerchantInfo> pageQuery(SendCodeMerchantPageReq pageReq);

    BaseResult addSendCode(SendCodeMerchantAddReq addReq);

    BaseResult updateSendCode(SendCodeMerchantUpdateReq updateReq);
}
