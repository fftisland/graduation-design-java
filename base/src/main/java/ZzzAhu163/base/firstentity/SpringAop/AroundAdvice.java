package ZzzAhu163.base.firstentity.SpringAop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * 环绕通知，这个MethodInterceptor接口是aop联盟提供的，不是Spring提供的Cglib提供的需要注意
 * 使用Cglib时我们也要继承一个MethodInterceptor接口，但是那个是Spring提供的
 * **/
public class AroundAdvice implements MethodInterceptor{
  @Override
  public Object invoke(MethodInvocation methodInvocation) throws Throwable {
    Method method = methodInvocation.getMethod();
    if (method.getName().equals("sayhello")) {
      before();
      methodInvocation.proceed();
      after();
    } else {
      methodInvocation.proceed();
    }
    return null;
  }

  private void before() {
    System.out.println("前置通知");
  }

  private void after() {
    System.out.println("后置通知");
  }
}
