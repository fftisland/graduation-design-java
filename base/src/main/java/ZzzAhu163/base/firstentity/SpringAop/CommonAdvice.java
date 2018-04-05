package ZzzAhu163.base.firstentity.SpringAop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class CommonAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("通过切面增强方法~~");
    }
}
