package db.merchant;

import admin.AdminBackendMain;
import admin.dao.SendCodeMerchantInfoMapper;
import admin.model.SendCodeMerchantInfo;
import admin.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminBackendMain.class)
@Slf4j
public class MerchantTest {

    @Autowired
    private SendCodeMerchantInfoMapper merchantInfoMapper;

    private final Random random = new Random();

    @Test
    public void batchRandomInsertMerchant() {
        List<SendCodeMerchantInfo> merchantList = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            SendCodeMerchantInfo info = new SendCodeMerchantInfo();
            info.setAccount("merchant_" + String.format("%03d", i));
            info.setPwd("pass_" + (1000 + random.nextInt(9000)));
            info.setAgentLevel(random.nextInt(5));  // 0-4
            info.setAgentBelong("agent_" + (1 + random.nextInt(10)));
            info.setWeight(random.nextInt(100) + 1);
            info.setBizPermissionType(random.nextInt(3) - 1);  // -1, 0, 1
            info.setBizList(generateRandomBizList());
            info.setIpWhitelist(generateRandomIPs());
            info.setStatus(random.nextBoolean() ? 1 : 0);
            info.setCreateTime(randomDate());
            info.setUpdateTime(randomDate());

            merchantList.add(info);
        }
        merchantInfoMapper.batchInsert(merchantList);
    }

    private String generateRandomBizList() {
        String[] all = {"SMS", "EMAIL", "PUSH", "API"};
        List<String> result = new ArrayList<>();
        int count = 1 + random.nextInt(3);
        while (result.size() < count) {
            String item = all[random.nextInt(all.length)];
            if (!result.contains(item)) result.add(item);
        }
        String json = JsonUtil.obj2Json(result);
        return json; // 格式模拟 JSON 字符串
    }

    private String generateRandomIPs() {
        int count = 1 + random.nextInt(3);
        List<String> ips = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ips.add("192.168." + random.nextInt(256) + "." + (1 + random.nextInt(254)));
        }
        return String.join(",", ips);
    }

    private Date randomDate() {
        long current = System.currentTimeMillis();
        long past = current - (long) random.nextInt(30 * 24 * 3600) * 1000L;
        return new Date(past);
    }
}
