package admin.controller;


import admin.common.BaseResult;
import admin.controller.req.user.LoginReq;
import admin.service.UserService;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 发码充值记录 前端控制器
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
        private UserService userService;

    @PostMapping("/login")
    public BaseResult userLogin(@RequestBody LoginReq loginReq) {
        try {
            log.info("userLogin begin! req = {}", JsonUtil.obj2Json(loginReq));
            BaseResult baseResult  = userService.login(loginReq);
            return baseResult;
        } catch (Exception e) {
            log.error("userLogin page error!", e);
            return BaseResult.buildError();
        }
    }

    @PostMapping("/info")
    public BaseResult userInfo() {
        try {
            log.info("userInfo begin!");
            BaseResult baseResult = userService.getUserInfo();
            log.info("userInfo end! res={}", JsonUtil.obj2Json(baseResult));
            return baseResult;
        } catch (Exception e) {
            log.error("userInfo page error!", e);
            return BaseResult.buildError();
        }
    }
}

