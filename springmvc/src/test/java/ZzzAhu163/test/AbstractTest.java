package ZzzAhu163.test;

import ZzzAhu163.utils.ConstValue.SharedPropertiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *测试类通用模板
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-spring-config.xml")
@Slf4j
public class AbstractTest {
  @Resource
  private SharedPropertiesProvider propertiesProvider;

  @Test
  public void test() {
    String env = propertiesProvider.getCurrentEnv();
    log.info("compile env {}", env);
  }
}
