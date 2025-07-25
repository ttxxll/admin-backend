package admin.interceptor;

import admin.enums.BizCodeEnum;
import admin.model.LoginUser;
import admin.utils.CommonUtil;
import admin.utils.JWTUtil;
import admin.utils.JsonData;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author taoxinglong
 * @description 登录拦截器，透传登录信息
 * @date 2024-04-07 21:50
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    public static ThreadLocal<LoginUser> userHolder = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 1.前端可能的刺探请求，类似健康检查
        if (HttpMethod.OPTIONS.toString().equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return true;
        }

        // 2.token解析验证：token一般放在header中
        String token = request.getHeader("X-Token");
        if (StringUtils.isBlank(token)) {
            // header中没有，可能在parameter中
            token = request.getParameter("X-Token");
        }

        if (StringUtils.isNotBlank(token)) {
            Claims claims = JWTUtil.checkJWT(token);
            if (claims == null) {
                CommonUtil.sendJsonMessage(response, JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
                return false;
            }

            String account = (String)claims.get("account");
            Long id = Long.parseLong((claims.get("id")+""));
            String roles = (String) claims.get("roles");
            LoginUser loginUser = new LoginUser();
            loginUser.setAccount(account);
            loginUser.setId(id);
            List<String> roleList = Arrays.stream(roles.split(",")).collect(Collectors.toList());
            loginUser.setRoles(roleList);
            /**
             * 3.登录信息透传
             *  1.可以放到request的attribute
             *  2.可以放到threadlocal
             */
            //request.setAttribute("loginUser", loginUser);
            userHolder.set(loginUser);
            return true;
        }

        log.error("token is empty! uri = {}", request.getRequestURI());
        CommonUtil.sendJsonMessage(response, JsonData.buildResult(BizCodeEnum.ACCOUNT_UNLOGIN));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 1.防止内存泄漏
        userHolder.remove();
    }
}
