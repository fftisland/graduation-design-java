package ZzzAhu163.base.firstentity;

public class serviceImpl implements service {
  @Override
  public void sayhello() {
    System.out.println("hello ~~~");
  }

  //TODO：现在我想增强serviceImpl的sayhello方法，但是又不能改变现有的类
  //1、使用静态代理，没什么说的
  //2、使用JDK动态代理
  //3、使用Cglib动态代理
}
