package admin.service.impl;

import admin.controller.req.SendCodeMerchantPageReq;
import admin.dto.PageDto;
import admin.model.SendCodeMerchantInfo;
import admin.dao.SendCodeMerchantInfoMapper;
import admin.service.SendCodeMerchantInfoService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        IPage<SendCodeMerchantInfo> orderDOIPage = sendCodeMerchantMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(orderDOIPage));
        List<SendCodeMerchantInfo> orderDOIPageRecords = orderDOIPage.getRecords();
        PageDto<SendCodeMerchantInfo> pageDto = new PageDto<>(orderDOIPage.getTotal(), orderDOIPage.getPages(), orderDOIPageRecords);
        return pageDto;
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
