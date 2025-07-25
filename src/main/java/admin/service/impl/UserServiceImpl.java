package admin.service.impl;

import admin.common.BaseResult;
import admin.controller.req.user.LoginReq;
import admin.controller.resp.LoginResp;
import admin.dao.SendCodeMerchantInfoMapper;
import admin.interceptor.LoginInterceptor;
import admin.model.LoginUser;
import admin.model.SendCodeMerchantInfo;
import admin.service.UserService;
import admin.utils.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-25 16:33
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SendCodeMerchantInfoMapper sendCodeMerchantInfoMapper;

    @Override
    public BaseResult login(LoginReq loginReq) {
        LambdaQueryWrapper<SendCodeMerchantInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SendCodeMerchantInfo::getAccount, loginReq.getUsername());
        queryWrapper.eq(SendCodeMerchantInfo::getPwd, loginReq.getPassword());
        SendCodeMerchantInfo merchantInfo = sendCodeMerchantInfoMapper.selectOne(queryWrapper);
        String token = JWTUtil.geneJsonWebToken(merchantInfo);
        LoginResp loginResp = new LoginResp();
        loginResp.setToken(token);
        return BaseResult.buildSuccess(loginResp);
    }

    @Override
    public BaseResult getUserInfo() {
        LoginUser loginUser = LoginInterceptor.userHolder.get();
        BaseResult baseResult = BaseResult.buildSuccess(loginUser);
        return baseResult;
    }
}
