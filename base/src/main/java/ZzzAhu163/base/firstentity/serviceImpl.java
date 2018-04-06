package ZzzAhu163.base.firstentity;

import org.springframework.stereotype.Component;

@Component("serviceImpl")
public class serviceImpl implements service {
  @Override
  public void sayhello() {
    System.out.println("hello ~~~");
  }

  //TODO：现在我想增强serviceImpl的sayhello方法，但是又不能改变现有的类
  //1、使用静态代理，没什么说的
  //2、使用JDK动态代理
  //3、使用Cglib动态代理

  //新方法，使用切面进行增强
  public void doSomething1() {
    System.out.println("doSomething1");
  }

  public void doSomething2() {
    System.out.println("doSomething2");
  }
}
