package admin.controller.req.sendcode;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SendCodeRecordPageReq extends SendCodeRecordBase{
    private Integer page;
    private Integer size;
}
