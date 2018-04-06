package ZzzAhu163.base.firstentity;

import ZzzAhu163.base.firstentity.Aspecj.MyAop;
import org.springframework.stereotype.Component;

@Component("aspectImpl")
public class AspectImpl {
  public void sayHello() {
    System.out.println("hello ~~~~");
  }

  public void doSomething() {
    System.out.println("doSomething ~~");
  }

  //自定义注解
  @MyAop
  public void annotationTest() {
    System.out.println("被注解标注的方法~~");
  }
}
