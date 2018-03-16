package ZzzAhu163.utils.ConstValue;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *@author ZzzAhu163
 *快速读取当前环境下配置文件信息的工具类
 **/
@Component("SharedPropertiesProvider")
@Data
@Slf4j
public class SharedPropertiesProvider {
  @Value("${shared.env}")
  private String currentEnv;
}
