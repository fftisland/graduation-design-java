package ZzzAhu163.base.firstentity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;

/**
 * Cglib的代理类
 * **/
public class cglibProxy implements MethodInterceptor{
  //自定义获取代理类方法
  public <T> T getProxy(Class<T> targetClass) {
    return (T) Enhancer.create(targetClass, this);
  }

  //cglib的这段代理会被打入字节码，也就是说，最终我们会获得一个全新的对象。也就没有方法被拦截一说，所以cglib生成慢，但是运行快
  @Override
  public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
    String methodName = method.getName();
    if (methodName.equals("sayhello")) {
      before();
      methodProxy.invokeSuper(proxy, objects);
      after();
    } else {
      methodProxy.invokeSuper(proxy, objects);
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
