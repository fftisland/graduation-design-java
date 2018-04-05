package ZzzAhu163.base.firstentity.SpringAop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterAdvice implements AfterReturningAdvice {
  @Override
  public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("sayhello")) {
      System.out.println("后置通知");
    } else {
      System.out.println("无法触发后置通知");
    }
  }
}
