package ZzzAhu163.test;

import ZzzAhu163.base.firstentity.*;
import ZzzAhu163.base.firstentity.SpringAop.AfterAdvice;
import ZzzAhu163.base.firstentity.SpringAop.AroundAdvice;
import ZzzAhu163.base.firstentity.SpringAop.BeforeAdvice;
import ZzzAhu163.base.firstentity.SpringAop.IntroductionAdvice;
import ZzzAhu163.utils.ConstValue.SharedPropertiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.reflect.Proxy;

/**
 *测试类通用模板
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:base-spring-config.xml")
@Slf4j
public class AbstractTest {
  @Resource
  SharedPropertiesProvider sharedPropertiesProvider;

  @Test
  public void PropertiesProvideTest() {
    String env = sharedPropertiesProvider.getCurrentEnv();
    log.info("current env {}", env);
  }

  /**代理相关知识梳理**/
  /**1、JDK动态代理，缺点，在生成代理对象的时候必须传入Interfaces()，也就是说非接口方法无法代理**/
  @Test
  public void JDKProxyTest() {
    //使用方法1:使用自定义的getProxy方法
    serviceImpl serviceImpl = new serviceImpl();
    serviceProxy serviceProxy = new serviceProxy(serviceImpl);
    service proxyService = serviceProxy.getProxy();
    proxyService.sayhello();

    //使用方法2:使用传统Proxy.newInstance
    serviceImpl serviceImpl2 = new serviceImpl();
    serviceProxy serviceProxy2 = new serviceProxy(serviceImpl2);
    service proxyService2 = (service) Proxy.newProxyInstance(
      serviceImpl2.getClass().getClassLoader(),
      serviceImpl2.getClass().getInterfaces(),
      serviceProxy2);
    proxyService2.sayhello();
  }

  /**2、Cglib动态代理，不需要继承接口，而且Cglib是字节码代理，所以我们不需要传入具体的对象，而只需要Class对象**/
  @Test
  public void cglibProxyTest() {
    //使用方法1：自定义的getProxy方法
    cglibProxy cglibProxy1 = new cglibProxy();
    service serviceProxy1 = cglibProxy1.getProxy(serviceImpl.class);
    serviceProxy1.sayhello();

    //使用方法2：传统Enhancer.create
    cglibProxy cglibProxy2 = new cglibProxy();
    service serviceProxy2 = (service) Enhancer.create(serviceImpl.class, cglibProxy2);
    serviceProxy2.sayhello();
  }

  /**3、Spring给提供的代理**/
  @Test
  public void springProxyTest() {
    //1、前置通知和后置通知分别使用
    ProxyFactory factory = new ProxyFactory();
    factory.setTarget(new serviceImpl());
    factory.addAdvice(new BeforeAdvice());
    factory.addAdvice(new AfterAdvice());
    service proxy = (service) factory.getProxy();
    proxy.sayhello();
    //2、环绕通知
    ProxyFactory factory2 = new ProxyFactory();
    factory2.setTarget(new serviceImpl());
    factory2.addAdvice(new AroundAdvice());
    service proxy2 = (service) factory2.getProxy();
    proxy2.sayhello();
  }

  /**4、Spring提供的代理引入功能**/
  @Test
  public void SpringIntroductionTest() {
    ProxyFactory factory = new ProxyFactory();
    factory.setTarget(new serviceImpl());
    factory.addAdvice(new IntroductionAdvice());
    //因为我们代理的是类，所以要设置下代理目标为Class = true
    factory.setProxyTargetClass(true);
    service proxy = (serviceImpl) factory.getProxy(); //只能代理成类，不能强转成接口
    proxy.sayhello();
    //代理后Spring给我们提供了强转成增强接口的功能，当然我么也可以直接在getProxy的时候直接返回NewInterface类型
    NewInterface newInterface = (NewInterface)proxy;
    newInterface.newFunction();
  }
}
