package admin.service.impl;

import admin.model.SendCodeRecord;
import admin.dao.SendCodeRecordMapper;
import admin.service.SendCodeRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 下发编码记录 服务实现类
 * </p>
 *
 * @author no
 * @since 2025-07-22
 */
@Service
public class SendCodeRecordServiceImpl extends ServiceImpl<SendCodeRecordMapper, SendCodeRecord> implements SendCodeRecordService {

}
