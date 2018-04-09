package ZzzAhu163.base.firstentity.BeanValidationLearning;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = StringNotEmptyValidator.class)
public @interface StringNotEmpty {
  public String message() default "String Is Not Allow To Empty";

  //必不可少的两个属性，group和payload，作用是什么之后会介绍
  public Class<?> [] groups() default {};
  public Class<? extends Payload>[] payload() default {};
}
