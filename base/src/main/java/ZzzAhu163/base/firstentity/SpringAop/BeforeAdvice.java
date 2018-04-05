package ZzzAhu163.base.firstentity.SpringAop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Spring前置通知类
 **/
public class BeforeAdvice implements MethodBeforeAdvice {

  @Override
  public void before(Method method, Object[] objects, Object o) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("sayhello")) {
      System.out.println("前置通知");
    } else {
      System.out.println("无法触发前置通知");
    }
  }
}
