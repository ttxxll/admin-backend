package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.merchant.SendCodeMerchantAddReq;
import admin.controller.req.merchant.SendCodeMerchantPageReq;
import admin.controller.req.merchant.SendCodeMerchantUpdateReq;
import admin.dao.SendCodeMerchantInfoMapper;
import admin.dto.PageDto;
import admin.model.SendCodeMerchantInfo;
import admin.service.SendCodeMerchantInfoService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 发码业务商户信息 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@Service
public class SendCodeMerchantInfoServiceImpl extends ServiceImpl<SendCodeMerchantInfoMapper, SendCodeMerchantInfo> implements SendCodeMerchantInfoService {

    @Autowired
    private SendCodeMerchantInfoMapper sendCodeMerchantMapper;

    public PageDto<SendCodeMerchantInfo> pageQuery(SendCodeMerchantPageReq pageReq) {
        Page<SendCodeMerchantInfo> pageInfo = new Page<>(pageReq.getPage(), pageReq.getSize());
        LambdaQueryWrapper<SendCodeMerchantInfo> queryWrapper = buildQueryWrapper(pageReq);
        IPage<SendCodeMerchantInfo> iPage = sendCodeMerchantMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(iPage));
        List<SendCodeMerchantInfo> pageRecords = iPage.getRecords();
        PageDto<SendCodeMerchantInfo> pageDto = new PageDto<>(iPage.getTotal(), iPage.getPages(), pageRecords);
        return pageDto;
    }

    @Override
    public BaseResult addSendCode(SendCodeMerchantAddReq addReq) {

        SendCodeMerchantInfo merchantInfo = new SendCodeMerchantInfo();
        BeanUtils.copyProperties(addReq, merchantInfo);
        int insert = sendCodeMerchantMapper.insert(merchantInfo);
        if (insert != 1) {
            return BaseResult.buildError();
        }
        return BaseResult.buildSuccess();
    }

    @Override
    public BaseResult updateSendCode(SendCodeMerchantUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeMerchantInfo> updateWrapper = buildUpdateWrapper(updateReq);
        sendCodeMerchantMapper.update(null, updateWrapper);
        return BaseResult.buildSuccess();
    }

    private LambdaUpdateWrapper<SendCodeMerchantInfo> buildUpdateWrapper(SendCodeMerchantUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeMerchantInfo> updateWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(updateReq.getBizList())) {
            updateWrapper.set(SendCodeMerchantInfo::getBizList, updateReq.getBizList());
        }
        if (Objects.nonNull(updateReq.getStatus())) {
            updateWrapper.set(SendCodeMerchantInfo::getStatus, updateReq.getStatus());
        }
        if (StringUtils.isNotBlank(updateReq.getAccount())) {
            updateWrapper.set(SendCodeMerchantInfo::getAccount, updateReq.getAccount());
        }
        if (StringUtils.isNotBlank(updateReq.getAgentBelong())) {
            updateWrapper.set(SendCodeMerchantInfo::getAgentBelong, updateReq.getAgentBelong());
        }
        if (Objects.nonNull(updateReq.getAgentLevel())) {
            updateWrapper.set(SendCodeMerchantInfo::getAgentLevel, updateReq.getAgentLevel());
        }
        if (Objects.nonNull(updateReq.getBizPermissionType())) {
            updateWrapper.set(SendCodeMerchantInfo::getBizPermissionType, updateReq.getBizPermissionType());
        }
        if (Objects.nonNull(updateReq.getWeight())) {
            updateWrapper.set(SendCodeMerchantInfo::getWeight, updateReq.getWeight());
        }
        return updateWrapper;
    }

    private LambdaQueryWrapper<SendCodeMerchantInfo> buildQueryWrapper(SendCodeMerchantPageReq pageReq) {
        LambdaQueryWrapper<SendCodeMerchantInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(pageReq.getStatus())) {
            queryWrapper.eq(SendCodeMerchantInfo::getStatus, pageReq.getStatus());
        }
        if (StringUtils.isNotBlank(pageReq.getAccount())) {
            queryWrapper.eq(SendCodeMerchantInfo::getAccount, pageReq.getAccount());
        }
        if (StringUtils.isNotBlank(pageReq.getAgentBelong())) {
            queryWrapper.eq(SendCodeMerchantInfo::getAgentBelong, pageReq.getAgentBelong());
        }
        if (Objects.nonNull(pageReq.getAgentLevel())) {
            queryWrapper.eq(SendCodeMerchantInfo::getAgentLevel, pageReq.getAgentLevel());
        }
        if (Objects.nonNull(pageReq.getBizPermissionType())) {
            queryWrapper.eq(SendCodeMerchantInfo::getBizPermissionType, pageReq.getBizPermissionType());
        }
        if (Objects.nonNull(pageReq.getWeight())) {
            queryWrapper.eq(SendCodeMerchantInfo::getWeight, pageReq.getWeight());
        }
        return queryWrapper;
    }
}
