package ZzzAhu163.base.firstentity.SpringAop;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("CommonAdvice")
public class CommonAdvice implements MethodBeforeAdvice{
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("通过切面增强方法~~");
    }
}
