package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.codebiz.SendCodeBizInfoAddReq;
import admin.controller.req.codebiz.SendCodeBizInfoPageReq;
import admin.controller.req.codebiz.SendCodeBizInfoUpdateReq;
import admin.dao.SendCodeBizInfoMapper;
import admin.dto.PageDto;
import admin.model.SendCodeBizInfo;
import admin.service.SendCodeBizInfoService;
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
        IPage<SendCodeBizInfo> iPage = sendCodeBizInfoMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(iPage));
        List<SendCodeBizInfo> pageRecords = iPage.getRecords();
        PageDto<SendCodeBizInfo> pageDto = new PageDto<>(iPage.getTotal(), iPage.getPages(), pageRecords);
        return pageDto;
    }

    @Override
    public BaseResult addSendCodeBiz(SendCodeBizInfoAddReq addReq) {
        SendCodeBizInfo bizInfo = new SendCodeBizInfo();
        BeanUtils.copyProperties(addReq, bizInfo);
        int insert = sendCodeBizInfoMapper.insert(bizInfo);
        if (insert != 1) {
            return BaseResult.buildError();
        }
        return BaseResult.buildSuccess();
    }

    @Override
    public BaseResult updateSendCodeBiz(SendCodeBizInfoUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeBizInfo> updateWrapper = buildUpdateWrapper(updateReq);
        sendCodeBizInfoMapper.update(null, updateWrapper);
        return BaseResult.buildSuccess();
    }

    private LambdaUpdateWrapper<SendCodeBizInfo> buildUpdateWrapper(SendCodeBizInfoUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodeBizInfo> updateWrapper = new LambdaUpdateWrapper<>();
        if (StringUtils.isNotBlank(updateReq.getBizName())) {
            updateWrapper.set(SendCodeBizInfo::getBizName, updateReq.getBizName());
        }
        if (StringUtils.isNotBlank(updateReq.getBizCode())) {
            updateWrapper.set(SendCodeBizInfo::getBizCode, updateReq.getBizCode());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformCode())) {
            updateWrapper.set(SendCodeBizInfo::getSendPlatformCode, updateReq.getSendPlatformCode());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformName())) {
            updateWrapper.set(SendCodeBizInfo::getSendPlatformName, updateReq.getSendPlatformName());
        }
        if (null != updateReq.getStatus()) {
            updateWrapper.set(SendCodeBizInfo::getStatus, updateReq.getStatus());
        }
        if (null != updateReq.getUnitPrice()) {
            updateWrapper.set(SendCodeBizInfo::getUnitPrice, updateReq.getUnitPrice());
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
