package admin.controller.req.codebiz;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendCodeBizInfoPageReq extends SendCodeBizInfoBase {
    private Integer page;
    private Integer size;
}
