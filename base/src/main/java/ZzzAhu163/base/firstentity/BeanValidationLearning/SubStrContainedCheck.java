package ZzzAhu163.base.firstentity.BeanValidationLearning;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 用来检测是否包含子字符串
 * @author ZzzAhu163
 * **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Documented
@Inherited
@Constraint(validatedBy = SubStrContainedValidator.class)
public @interface SubStrContainedCheck {
  public String subStr() default "";

  public String message() default "不包含指定子串";

  //必须属性
  public Class<?> [] groups() default {};
  public Class<? extends Payload>[] payload() default {};

  @Retention(RetentionPolicy.RUNTIME)
  @Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
  @interface List {
    public SubStrContainedCheck [] value() default {};
  }
}
