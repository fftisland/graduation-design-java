package ZzzAhu163.service;


import ZzzAhu163.base.firstentity.first;
import ZzzAhu163.service.FirstService.FirstService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-spring-config.xml")
@Slf4j
public class AbstractTest {
  @Resource
  FirstService firstService;

  @Test
  public void test() {
    first first = new first();
    first.setData("service测试");
    boolean result = firstService.insertFirstData(first);
    log.info("service result：" + result);
  }

}
