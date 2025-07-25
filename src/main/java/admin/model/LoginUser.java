package admin.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author taoxinglong
 * @description TODO
 * @date 2025-07-25 16:46
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginUser {

    private Long id;

    /**
     * 账号
     */
    private String account;

    private String name;

    private String avatar = "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif";

    private String introduction = "测试介绍";

    /**
     * 认证级别
     */
    private List<String> roles;
}
