package ZzzAhu163.base.firstentity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理serviceImpl
 * **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class serviceProxy implements InvocationHandler{
  private Object target;

  //自定义获取代理后对象方法
  public <T> T getProxy() {
    return (T) Proxy.newProxyInstance(
      target.getClass().getClassLoader(), //传入被代理类的类加载器
      target.getClass().getInterfaces(),  //传入被代理类的接口
      this);                           //代理器
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    //proxy对象通常用不到
    String methodName = method.getName();
    if (methodName.equals("sayhello")) { //动态代理增强sayhello方法
      before();
      method.invoke(target, args); //proxy其实就是被拦截的代理对象，如果使用method.invoke(proxy, args)将进入死循环
      after();                      //所以JDK动态代理，执行非增强逻辑的还是原对象target
    } else {
      method.invoke(target, args);
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
