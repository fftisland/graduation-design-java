package test;

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

}
