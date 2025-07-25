package admin.service;

import admin.common.BaseResult;
import admin.controller.req.user.LoginReq;

public interface UserService {

    BaseResult login(LoginReq loginReq);

    BaseResult getUserInfo();

}
