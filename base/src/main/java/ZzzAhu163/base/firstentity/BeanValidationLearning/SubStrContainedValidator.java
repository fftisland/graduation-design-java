package ZzzAhu163.base.firstentity.BeanValidationLearning;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SubStrContainedValidator implements ConstraintValidator<SubStrContainedCheck, String> {
  //指定的子串
  private String subStr;

  @Override
  public void initialize(SubStrContainedCheck subStrContainedCheck) {
    this.subStr = subStrContainedCheck.subStr();
  }

  @Override
  public boolean isValid(String fieldValue, ConstraintValidatorContext constraintValidatorContext) {
    if (StringUtils.isEmpty(fieldValue)) {
      return false;
    }
    if (StringUtils.contains(fieldValue, subStr)) {
      return true;
    }
    return false;
  }
}
