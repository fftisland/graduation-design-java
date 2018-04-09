package ZzzAhu163.utils.BeanValidationUtil;

import java.lang.annotation.*;

/**
 * 作用：标记类需要进行类级别的Validator验证
 * @author ZzzAhu163
 * 如果要使用类级别的约束，message是无法进行预设的
 * 所以要在类中手动设定
 * **/
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClassLevelConstraint {
  //仅仅起到标记作用
}
