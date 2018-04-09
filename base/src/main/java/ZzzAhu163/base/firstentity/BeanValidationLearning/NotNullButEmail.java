package ZzzAhu163.base.firstentity.BeanValidationLearning;

import org.hibernate.validator.constraints.Email;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@NotNull(message = "属性不能为NUll")
@Email(message = "属性必须为邮件格式")
@Constraint(validatedBy = {}) //别忘了，要做验证注解，必需指定@Constraint
public @interface NotNullButEmail {
  public String message() default "";

  //必需配置
  public Class<?>[] groups() default {};
  public Class<? extends Payload> [] payload() default {};
}
