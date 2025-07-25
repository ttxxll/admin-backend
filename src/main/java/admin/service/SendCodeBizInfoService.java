package admin.service;

import admin.common.BaseResult;
import admin.controller.req.codebiz.SendCodeBizInfoAddReq;
import admin.controller.req.codebiz.SendCodeBizInfoPageReq;
import admin.controller.req.codebiz.SendCodeBizInfoUpdateReq;
import admin.dto.PageDto;
import admin.model.SendCodeBizInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 发码业务信息 服务类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
public interface SendCodeBizInfoService extends IService<SendCodeBizInfo> {

    PageDto<SendCodeBizInfo> pageQuery(SendCodeBizInfoPageReq pageReq);

    BaseResult addSendCodeBiz(SendCodeBizInfoAddReq addReq);

    BaseResult updateSendCodeBiz(SendCodeBizInfoUpdateReq updateReq);
}
