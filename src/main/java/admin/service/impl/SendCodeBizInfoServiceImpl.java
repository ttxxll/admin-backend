package admin.service.impl;

import admin.controller.req.SendCodeMerchantUpdateReq;
import admin.controller.req.codebiz.SendCodeBizInfoPageReq;
import admin.dao.SendCodeBizInfoMapper;
import admin.dto.PageDto;
import admin.model.SendCodeBizInfo;
import admin.model.SendCodeMerchantInfo;
import admin.service.SendCodeBizInfoService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 发码业务信息 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@Service
public class SendCodeBizInfoServiceImpl extends ServiceImpl<SendCodeBizInfoMapper, SendCodeBizInfo> implements SendCodeBizInfoService {

    @Autowired
    private SendCodeBizInfoMapper sendCodeBizInfoMapper;

    @Override
    public PageDto<SendCodeBizInfo> pageQuery(SendCodeBizInfoPageReq pageReq) {
        Page<SendCodeBizInfo> pageInfo = new Page<>(pageReq.getPage(), pageReq.getSize());
        LambdaQueryWrapper<SendCodeBizInfo> queryWrapper = buildQueryWrapper(pageReq);
        IPage<SendCodeBizInfo> orderDOIPage = sendCodeBizInfoMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(orderDOIPage));
        List<SendCodeBizInfo> orderDOIPageRecords = orderDOIPage.getRecords();
        PageDto<SendCodeBizInfo> pageDto = new PageDto<>(orderDOIPage.getTotal(), orderDOIPage.getPages(), orderDOIPageRecords);
        return pageDto;
    }



//    @Override
//    public BaseResult addSendCode(SendCodeMerchantAddReq addReq) {
//
//        SendCodeMerchantInfo merchantInfo = new SendCodeMerchantInfo();
//        BeanUtils.copyProperties(addReq, merchantInfo);
//        int insert = sendCodeMerchantMapper.insert(merchantInfo);
//        if (insert != 1) {
//            return BaseResult.buildError();
//        }
//        return BaseResult.buildSuccess();
//    }

//    @Override
//    public BaseResult updateSendCode(SendCodeMerchantUpdateReq updateReq) {
//        LambdaUpdateWrapper<SendCodeMerchantInfo> updateWrapper = buildUpdateWrapper(updateReq);
//        sendCodeMerchantMapper.update(null, updateWrapper);
//        return BaseResult.buildSuccess();
//    }

    private LambdaUpdateWrapper<SendCodeMerchantInfo> buildUpdateWrapper(SendCodeMerchantUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeMerchantInfo> updateWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(updateReq.getBizList())) {
            updateWrapper.eq(SendCodeMerchantInfo::getBizList, updateReq.getBizList());
        }
        if (Objects.nonNull(updateReq.getStatus())) {
            updateWrapper.eq(SendCodeMerchantInfo::getStatus, updateReq.getStatus());
        }
        if (StringUtils.isNotBlank(updateReq.getAccount())) {
            updateWrapper.eq(SendCodeMerchantInfo::getAccount, updateReq.getAccount());
        }
        if (StringUtils.isNotBlank(updateReq.getAgentBelong())) {
            updateWrapper.eq(SendCodeMerchantInfo::getAgentBelong, updateReq.getAgentBelong());
        }
        if (Objects.nonNull(updateReq.getAgentLevel())) {
            updateWrapper.eq(SendCodeMerchantInfo::getAgentLevel, updateReq.getAgentLevel());
        }
        if (Objects.nonNull(updateReq.getBizPermissionType())) {
            updateWrapper.eq(SendCodeMerchantInfo::getBizPermissionType, updateReq.getBizPermissionType());
        }
        if (Objects.nonNull(updateReq.getWeight())) {
            updateWrapper.eq(SendCodeMerchantInfo::getWeight, updateReq.getWeight());
        }
        return updateWrapper;
    }

    private LambdaQueryWrapper<SendCodeBizInfo> buildQueryWrapper(SendCodeBizInfoPageReq pageReq) {
        LambdaQueryWrapper<SendCodeBizInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(pageReq.getStatus())) {
            queryWrapper.eq(SendCodeBizInfo::getStatus, pageReq.getStatus());
        }
        if (StringUtils.isNotBlank(pageReq.getBizName())) {
            queryWrapper.eq(SendCodeBizInfo::getBizName, pageReq.getBizName());
        }
        if (StringUtils.isNotBlank(pageReq.getBizCode())) {
            queryWrapper.eq(SendCodeBizInfo::getBizCode, pageReq.getBizCode());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformName())) {
            queryWrapper.eq(SendCodeBizInfo::getSendPlatformName, pageReq.getSendPlatformName());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformCode())) {
            queryWrapper.eq(SendCodeBizInfo::getSendPlatformCode, pageReq.getSendPlatformCode());
        }

        return queryWrapper;
    }
}
