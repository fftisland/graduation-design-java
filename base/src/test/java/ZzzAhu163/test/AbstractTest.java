package ZzzAhu163.test;

import ZzzAhu163.base.firstentity.*;
import ZzzAhu163.base.firstentity.Aspecj.AspectIntroduce;
import ZzzAhu163.base.firstentity.BeanValidationLearning.NotNullButEmailBean;
import ZzzAhu163.base.firstentity.BeanValidationLearning.StringNotEmpty;
import ZzzAhu163.base.firstentity.BeanValidationLearning.StringNotEmptyBean;
import ZzzAhu163.base.firstentity.SpringAop.*;
import ZzzAhu163.utils.BeanValidationUtil.BeanValidationUtil;
import ZzzAhu163.utils.ConstValue.SharedPropertiesProvider;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CosNaming.NamingContextPackage.NotEmpty;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.aop.support.RegexpMethodPointcutAdvisor;
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


  /**5、切面功能
   * 前面了解了JDK动态代理，Cglib动态代理以及Spring提供的动态代理，但是他们都有个缺点
   * 那就是，我们在进行通知织入的时候，都需要通过Method自己来判断是否需要使用Advice
   * 秉着复杂就一定有问题的原则，让我们开始接触AOP编程
   *
   * 如果我们能把对Method的判断和Advice直接绑定在一起，是不是会很方便呢？
   * 对的，对Method的判断其实就是PointCut(切点)的概念，而 Advice + PointCut就是一个切面，Advisor
   * **/
  @Test
  public void SpringAdvisorTest() {
    /**Spring默认给我们提供了几个自带的切面类，下面这个是基于正则对的切面类**/
    ProxyFactory proxyFactory = new ProxyFactory();
    proxyFactory.setTarget(new serviceImpl());
    proxyFactory.setProxyTargetClass(true);
    //切面
    RegexpMethodPointcutAdvisor advisor = new RegexpMethodPointcutAdvisor();
    //切点，
    advisor.setPattern(".*");
    //通知
    advisor.setAdvice(new CommonAdvice());
    //织入切面
    proxyFactory.addAdvisor(advisor);
    //获取代理
    serviceImpl proxy = (serviceImpl) proxyFactory.getProxy();

    proxy.sayhello();
    proxy.doSomething1();
    proxy.doSomething2();
  }

  /**
   * 6、ProxyFactory我们已经熟悉了，但是我们要是想批量代理需要类，这个时候要如何呢。
   * Spring给我们提供了批量代理工厂BeanNameAutoProxyCreator
   * **/

  @Resource
  private serviceImpl serviceImpl;
  @Test
  public void BatchProxyFactory() {
    //由于是代理的Bean，所以BeanNameAutoProxyCreator也要配置成Bean
    //现在我们获取目标Bean，发现已经是被代理后的Bean了
    serviceImpl.sayhello();
    serviceImpl.doSomething1();
    serviceImpl.doSomething2();
  }

  /**
   * 7、不过我们还是发现会有不妥之处，那就是Spring提供的AOP模板过于死板
   * 举个例子：我有三个不同的类，每个类有三个不同的方法，这种情况下 我就要写很多AOP配置
   * 所以，最终Spring在保留了自己AOP功能的同时，集成了AspectJ
   * 目前通常都是使用Spring + AspectJ，根据execution表达式拦截方法实现AOP
   *
   * 开启Aspect切面只需要在xml中开启配置即可
   * **/
  @Resource
  private AspectImpl aspectImpl;
  @Test
  public void AspectAOPTest() {
    aspectImpl.sayHello();
    aspectImpl.doSomething();
  }

  /**8、不仅仅使用execution表达式匹配方法，
   * 还支持使用@annotation()注解来标志需要进行拦截**/
  @Test
  public void AnnotationAopTest() {
    aspectImpl.annotationTest();
  }

  /**Aspect同样给我们提供了引入增强的方法**/
  @Test
  public void AspectIntroduction() {
    AspectIntroduce introduce = (AspectIntroduce)aspectImpl;
    introduce.aspectDisplay();
  }

  /**来测试下我们写的BeanValidation验证工具类**/
  @Resource
  BeanValidationUtil beanValidationUtil;
  @Test
  public void utilTest() {
    StringNotEmptyBean bean = new StringNotEmptyBean();
    String message = beanValidationUtil.validate(bean);
    log.info("验证结果：{}", message);
  }
}
