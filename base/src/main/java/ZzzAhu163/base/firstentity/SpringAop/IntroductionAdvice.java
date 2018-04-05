package ZzzAhu163.base.firstentity.SpringAop;

import ZzzAhu163.base.firstentity.NewInterface;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

import java.lang.reflect.Method;

/**
 * 方法的增强叫织入，给类增加方法的功能叫做引入
 * Spring给我们提供了引入的功能
 * **/
public class IntroductionAdvice extends DelegatingIntroductionInterceptor implements NewInterface{

  //如果只是想新增一个方法，则原方法直接放行即可,甚至可以不重写这个方法
  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    return super.invoke(invocation);
  }


  @Override
  public void newFunction() {
    System.out.println("这是一个新功能");
  }
}
