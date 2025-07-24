package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.sendcode.SendCodeRecordAddReq;
import admin.controller.req.sendcode.SendCodeRecordPageReq;
import admin.controller.req.sendcode.SendCodeRecordUpdateReq;
import admin.dao.SendCodeRecordMapper;
import admin.dto.PageDto;
import admin.model.SendCodeRecord;
import admin.service.SendCodeRecordService;
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
 * 下发编码记录 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@Service
public class SendCodeRecordServiceImpl extends ServiceImpl<SendCodeRecordMapper, SendCodeRecord> implements SendCodeRecordService {

    @Autowired
    private SendCodeRecordMapper sendCodeRecordMapper;

    @Override
    public PageDto<SendCodeRecord> sendCodeRecordPage(SendCodeRecordPageReq pageReq) {
        Page<SendCodeRecord> pageInfo = new Page<>(pageReq.getPage(), pageReq.getSize());
        LambdaQueryWrapper<SendCodeRecord> queryWrapper = buildQueryWrapper(pageReq);
        IPage<SendCodeRecord> iPage = sendCodeRecordMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(iPage));
        List<SendCodeRecord> pageRecords = iPage.getRecords();
        PageDto<SendCodeRecord> pageDto = new PageDto<>(iPage.getTotal(), iPage.getPages(), pageRecords);
        return pageDto;
    }

    @Override
    public BaseResult addSendCodeRecord(SendCodeRecordAddReq addReq) {
        SendCodeRecord sendCodeRecord = new SendCodeRecord();
        BeanUtils.copyProperties(addReq, sendCodeRecord);
        int insert = sendCodeRecordMapper.insert(sendCodeRecord);
        if (insert != 1) {
            return BaseResult.buildError();
        }
        return BaseResult.buildSuccess();
    }

    @Override
    public BaseResult updateSendCodeRecord(SendCodeRecordUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeRecord> updateWrapper = buildUpdateWrapper(updateReq);
        sendCodeRecordMapper.update(null, updateWrapper);
        return BaseResult.buildSuccess();
    }

    private LambdaUpdateWrapper<SendCodeRecord> buildUpdateWrapper(SendCodeRecordUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeRecord> updateWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(updateReq.getIssuedCode())) {
            updateWrapper.set(SendCodeRecord::getIssuedCode, updateReq.getIssuedCode());
        }
        if (StringUtils.isNotBlank(updateReq.getIssuedPhone())) {
            updateWrapper.set(SendCodeRecord::getIssuedPhone, updateReq.getIssuedPhone());
        }
        if (Objects.nonNull(updateReq.getBizId())) {
            updateWrapper.set(SendCodeRecord::getBizId, updateReq.getBizId());
        }
        if (StringUtils.isNotBlank(updateReq.getBizCode())) {
            updateWrapper.set(SendCodeRecord::getBizCode, updateReq.getBizCode());
        }
        if (StringUtils.isNotBlank(updateReq.getBizName())) {
            updateWrapper.set(SendCodeRecord::getBizName, updateReq.getBizName());
        }
        if (Objects.nonNull(updateReq.getMerchantId())) {
            updateWrapper.set(SendCodeRecord::getMerchantId, updateReq.getMerchantId());
        }
        if (StringUtils.isNotBlank(updateReq.getAccount())) {
            updateWrapper.set(SendCodeRecord::getAccount, updateReq.getAccount());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformCode())) {
            updateWrapper.set(SendCodeRecord::getSendPlatformCode, updateReq.getSendPlatformCode());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformName())) {
            updateWrapper.set(SendCodeRecord::getSendPlatformName, updateReq.getSendPlatformName());
        }
        if (Objects.nonNull(updateReq.getStatus())) {
            updateWrapper.set(SendCodeRecord::getStatus, updateReq.getStatus());
        }
        return updateWrapper;
    }

    private LambdaQueryWrapper<SendCodeRecord> buildQueryWrapper(SendCodeRecordPageReq pageReq) {
        LambdaQueryWrapper<SendCodeRecord> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageReq.getIssuedCode())) {
            queryWrapper.eq(SendCodeRecord::getIssuedCode, pageReq.getIssuedCode());
        }
        if (StringUtils.isNotBlank(pageReq.getIssuedPhone())) {
            queryWrapper.eq(SendCodeRecord::getIssuedPhone, pageReq.getIssuedPhone());
        }
        if (Objects.nonNull(pageReq.getBizId())) {
            queryWrapper.eq(SendCodeRecord::getBizId, pageReq.getBizId());
        }
        if (StringUtils.isNotBlank(pageReq.getBizCode())) {
            queryWrapper.eq(SendCodeRecord::getBizCode, pageReq.getBizCode());
        }
        if (StringUtils.isNotBlank(pageReq.getBizName())) {
            queryWrapper.eq(SendCodeRecord::getBizName, pageReq.getBizName());
        }
        if (Objects.nonNull(pageReq.getMerchantId())) {
            queryWrapper.eq(SendCodeRecord::getMerchantId, pageReq.getMerchantId());
        }
        if (StringUtils.isNotBlank(pageReq.getAccount())) {
            queryWrapper.eq(SendCodeRecord::getAccount, pageReq.getAccount());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformCode())) {
            queryWrapper.eq(SendCodeRecord::getSendPlatformCode, pageReq.getSendPlatformCode());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformName())) {
            queryWrapper.eq(SendCodeRecord::getSendPlatformName, pageReq.getSendPlatformName());
        }
        if (Objects.nonNull(pageReq.getStatus())) {
            queryWrapper.eq(SendCodeRecord::getStatus, pageReq.getStatus());
        }
        return queryWrapper;
    }
}
