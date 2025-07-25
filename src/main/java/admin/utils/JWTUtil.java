package admin.utils;

import admin.model.SendCodeMerchantInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author taoxinglong
 * @description JWT工具类
 * @date 2024-04-06 23:16
 */
@Slf4j
public class JWTUtil {

    // 主题
    private static final String SUBJECT = "admin-backend";

    // 加密密钥
    private static final String SECRET = "admin-backendk-secret";

    // 令牌前缀
    private static final String TOKNE_PREFIX = "admin-backend";

    // token过期时间，1天
    private static final long EXPIRED = 1000 * 60 * 60 * 12 * 1;

    /**
     * 生成token
     *
     * @param loginUser
     * @return
     */
    public static String geneJsonWebToken(SendCodeMerchantInfo loginUser) {

        String token = Jwts.builder().setSubject(SUBJECT)
                //配置payload
                .claim("id", loginUser.getId())
                .claim("account", loginUser.getAccount())
                .claim("roles", loginUser.getRoles())
                // 发布时间
                .setIssuedAt(new Date())
                .setExpiration(new Date(CommonUtil.getCurrentTimestamp() + EXPIRED))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKNE_PREFIX + token;
        return token;
    }


    /**
     * 解密jwt
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {

        try {
            return Jwts.parser().setSigningKey(SECRET)
                    // 去掉前缀
                    .parseClaimsJws(token.replace(TOKNE_PREFIX, "")).getBody();
        } catch (Exception e) {
            log.error("jwt parse error : ", e);
            return null;
        }
    }
}
