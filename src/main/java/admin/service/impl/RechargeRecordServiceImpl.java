package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.recharge.RechargeRecordAddReq;
import admin.controller.req.recharge.RechargeRecordPageReq;
import admin.controller.req.recharge.RechargeRecordUpdateReq;
import admin.dao.RechargeRecordMapper;
import admin.dto.PageDto;
import admin.model.RechargeRecord;
import admin.service.RechargeRecordService;
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
 * 发码充值记录 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@Service
public class RechargeRecordServiceImpl extends ServiceImpl<RechargeRecordMapper, RechargeRecord> implements RechargeRecordService {

    @Autowired
    private RechargeRecordMapper rechargeRecordMapper;

    @Override
    public PageDto<RechargeRecord> rechargeRecordPage(RechargeRecordPageReq pageReq) {
        Page<RechargeRecord> pageInfo = new Page<>(pageReq.getPage(), pageReq.getSize());
        LambdaQueryWrapper<RechargeRecord> queryWrapper = buildQueryWrapper(pageReq);
        IPage<RechargeRecord> iPage = rechargeRecordMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(iPage));
        List<RechargeRecord> pageRecords = iPage.getRecords();
        PageDto<RechargeRecord> pageDto = new PageDto<>(iPage.getTotal(), iPage.getPages(), pageRecords);
        return pageDto;
    }

    @Override
    public BaseResult addRechargeRecord(RechargeRecordAddReq addReq) {
        RechargeRecord rechargeRecord = new RechargeRecord();
        BeanUtils.copyProperties(addReq, rechargeRecord);
        int insert = rechargeRecordMapper.insert(rechargeRecord);
        if (insert != 1) {
            return BaseResult.buildError();
        }
        return BaseResult.buildSuccess();
    }

    @Override
    public BaseResult updateRechargeRecord(RechargeRecordUpdateReq updateReq) {
        LambdaUpdateWrapper<RechargeRecord> updateWrapper = buildUpdateWrapper(updateReq);
        rechargeRecordMapper.update(null, updateWrapper);
        return BaseResult.buildSuccess();
    }

    private LambdaUpdateWrapper<RechargeRecord> buildUpdateWrapper(RechargeRecordUpdateReq updateReq) {
        LambdaUpdateWrapper<RechargeRecord> updateWrapper = new LambdaUpdateWrapper<>();
        if (Objects.nonNull(updateReq.getRechargeQuantity())) {
            updateWrapper.set(RechargeRecord::getRechargeQuantity, updateReq.getRechargeQuantity());
        }
        if (Objects.nonNull(updateReq.getMerchantId())) {
            updateWrapper.set(RechargeRecord::getMerchantId, updateReq.getMerchantId());
        }
        if (StringUtils.isNotBlank(updateReq.getAccount())) {
            updateWrapper.set(RechargeRecord::getAccount, updateReq.getAccount());
        }
        if (StringUtils.isNotBlank(updateReq.getBizName())) {
            updateWrapper.set(RechargeRecord::getBizName, updateReq.getBizName());
        }
        if (StringUtils.isNotBlank(updateReq.getBizCode())) {
            updateWrapper.set(RechargeRecord::getBizCode, updateReq.getBizCode());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformName())) {
            updateWrapper.set(RechargeRecord::getSendPlatformName, updateReq.getSendPlatformName());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformCode())) {
            updateWrapper.set(RechargeRecord::getSendPlatformCode, updateReq.getSendPlatformCode());
        }
        return updateWrapper;
    }

    private LambdaQueryWrapper<RechargeRecord> buildQueryWrapper(RechargeRecordPageReq pageReq) {
        LambdaQueryWrapper<RechargeRecord> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(pageReq.getRechargeQuantity())) {
            queryWrapper.eq(RechargeRecord::getRechargeQuantity, pageReq.getRechargeQuantity());
        }
        if (Objects.nonNull(pageReq.getMerchantId())) {
            queryWrapper.eq(RechargeRecord::getMerchantId, pageReq.getMerchantId());
        }
        if (StringUtils.isNotBlank(pageReq.getAccount())) {
            queryWrapper.eq(RechargeRecord::getAccount, pageReq.getAccount());
        }
        if (StringUtils.isNotBlank(pageReq.getBizName())) {
            queryWrapper.eq(RechargeRecord::getBizName, pageReq.getBizName());
        }
        if (StringUtils.isNotBlank(pageReq.getBizCode())) {
            queryWrapper.eq(RechargeRecord::getBizCode, pageReq.getBizCode());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformName())) {
            queryWrapper.eq(RechargeRecord::getSendPlatformName, pageReq.getSendPlatformName());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformCode())) {
            queryWrapper.eq(RechargeRecord::getSendPlatformCode, pageReq.getSendPlatformCode());
        }
        return queryWrapper;
    }

}
