package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.platform.SendCodePlatformAddReq;
import admin.controller.req.platform.SendCodePlatformPageReq;
import admin.controller.req.platform.SendCodePlatformUpdateReq;
import admin.dao.SendCodePlatformInfoMapper;
import admin.dto.PageDto;
import admin.model.SendCodePlatformInfo;
import admin.service.SendCodePlatformService;
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
 * 下发编码平台 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@Service
public class SendCodePlatformServiceImpl extends ServiceImpl<SendCodePlatformInfoMapper, SendCodePlatformInfo> implements SendCodePlatformService {

    @Autowired
    private SendCodePlatformInfoMapper sendCodePlatformInfoMapper;

    @Override
    public PageDto<SendCodePlatformInfo> codePlatformPage(SendCodePlatformPageReq pageReq) {
        Page<SendCodePlatformInfo> pageInfo = new Page<>(pageReq.getPage(), pageReq.getSize());
        LambdaQueryWrapper<SendCodePlatformInfo> queryWrapper = buildQueryWrapper(pageReq);
        IPage<SendCodePlatformInfo> iPage = sendCodePlatformInfoMapper.selectPage(pageInfo, queryWrapper);
        log.info("pageQuery success! list = {}, ", JSONObject.toJSONString(iPage));
        List<SendCodePlatformInfo> pageRecords = iPage.getRecords();
        PageDto<SendCodePlatformInfo> pageDto = new PageDto<>(iPage.getTotal(), iPage.getPages(), pageRecords);
        return pageDto;
    }

    @Override
    public BaseResult addCodePlatform(SendCodePlatformAddReq addReq) {
        SendCodePlatformInfo codePlatform = new SendCodePlatformInfo();
        BeanUtils.copyProperties(addReq, codePlatform);
        int insert = sendCodePlatformInfoMapper.insert(codePlatform);
        if (insert != 1) {
            return BaseResult.buildError();
        }
        return BaseResult.buildSuccess();
    }

    @Override
    public BaseResult updateCodePlatform(SendCodePlatformUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodePlatformInfo> updateWrapper = buildUpdateWrapper(updateReq);
        sendCodePlatformInfoMapper.update(null, updateWrapper);
        return BaseResult.buildSuccess();
    }

    private LambdaUpdateWrapper<SendCodePlatformInfo> buildUpdateWrapper(SendCodePlatformUpdateReq updateReq) {
        LambdaUpdateWrapper<SendCodePlatformInfo> updateWrapper = new LambdaUpdateWrapper<>();

        if (StringUtils.isNotBlank(updateReq.getSendPlatformCode())) {
            updateWrapper.set(SendCodePlatformInfo::getSendPlatformCode, updateReq.getSendPlatformCode());
        }
        if (StringUtils.isNotBlank(updateReq.getSendPlatformName())) {
            updateWrapper.set(SendCodePlatformInfo::getSendPlatformName, updateReq.getSendPlatformName());
        }
        if (null != updateReq.getStatus()) {
            updateWrapper.set(SendCodePlatformInfo::getStatus, updateReq.getStatus());
        }
        return updateWrapper;
    }

    private LambdaQueryWrapper<SendCodePlatformInfo> buildQueryWrapper(SendCodePlatformPageReq pageReq) {
        LambdaQueryWrapper<SendCodePlatformInfo> queryWrapper = new LambdaQueryWrapper<>();
        if (Objects.nonNull(pageReq.getStatus())) {
            queryWrapper.eq(SendCodePlatformInfo::getStatus, pageReq.getStatus());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformCode())) {
            queryWrapper.eq(SendCodePlatformInfo::getSendPlatformCode, pageReq.getSendPlatformCode());
        }
        if (StringUtils.isNotBlank(pageReq.getSendPlatformName())) {
            queryWrapper.eq(SendCodePlatformInfo::getSendPlatformName, pageReq.getSendPlatformName());
        }
        return queryWrapper;
    }

}
