package ZzzAhu163.base.firstentity.Aspecj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 使用了@Aspect注解就相当于表示当前类是个切面类Advisor
 * **/
@Aspect
@Component("AspectJAdvisor")
public class AspectJAdvisor {
  //execution()表示需要拦截方法，里面是匹配规则表达式
  @Around("execution(* ZzzAhu163.base.firstentity.AspectImpl.*Hello(..))")
  public void beforeAdvice(ProceedingJoinPoint proceed) throws Throwable {
    before();
    proceed.proceed();
    after();
  }

  @Around("@annotation(MyAop)")
  public void annotationAop(ProceedingJoinPoint proceed) throws Throwable {
    System.out.println("通过注解进行切面配置");
    proceed.proceed();
  }


  private void before() {
    System.out.println("前置通知~");
  }

  private void after() {
    System.out.println("后置通知~");
  }


  //使用注解增强引入，这样我们就能够使用value的类强转成这个接口的实现类，从而调用defaultImpl中实现的方法
  @DeclareParents(value = "ZzzAhu163.base.firstentity.AspectImpl", defaultImpl = AspectIntroduction.class)
  private AspectIntroduce introduce;

}
