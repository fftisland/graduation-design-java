package ZzzAhu163.base.firstentity.BeanValidationLearning;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StringNotEmptyValidator implements ConstraintValidator<StringNotEmpty, String> {

  @Override
  public void initialize(StringNotEmpty stringNotEmpty) {
    //这个方法的作用，下一个自定义注解我们再来演示
  }

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isNotEmpty(fieldValue)) {
      return true;
    }
    return false;
  }
}
