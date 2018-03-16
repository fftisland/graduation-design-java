package test;

import ZzzAhu163.base.firstentity.first;
import ZzzAhu163.mapper.firstmapper.FirstMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 *@author ZzzAhu163
 *mapper测试类父类
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mapper-spring-config.xml")
@Slf4j
public class AbstractTest {
  @Resource
  FirstMapper firstMapper;
  @Test
  public void test() {
    first first = new first();
    first.setData("第一条数据");
    firstMapper.insertFirstData(first);
    log.info("自增主键 {}", first.getId());
  }
}
