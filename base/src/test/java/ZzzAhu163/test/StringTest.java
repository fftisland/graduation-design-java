package ZzzAhu163.test;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.UUID;

@Slf4j
public class StringTest extends AbstractTest{
    @Test
    public void UUIDTet() {
        String random = UUID.randomUUID().toString();
        log.info("UUID字符串 {}", random);
    }

    @Test
    public void timeStringTest() {
        String format = "yyyyMMdd_hhMMss";
        String timeString = SharedStringUtil.formatTime(format, null);
        log.info("时间格式化：{}", timeString);
    }

    @Test
    public void getRandStringTest() {
        String randomName = SharedStringUtil.getRandomString();
        log.info("随机字符串： {}", randomName);
    }
}
