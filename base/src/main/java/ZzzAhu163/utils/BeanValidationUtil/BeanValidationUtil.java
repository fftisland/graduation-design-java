package ZzzAhu163.utils.BeanValidationUtil;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Set;

/**
 * @author ZzzAhu163
 * 验证的工具类
 * **/
@Component("beanValidationUtil")
public class BeanValidationUtil {
  private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
  private static Validator validator = factory.getValidator();

  public static String validate(Object bean) {
    Preconditions.checkNotNull(bean);

    Class beanClass = bean.getClass();
    //只验证类本身的所有字段
    for (Field field : beanClass.getDeclaredFields()) {
      String message = ValidateProperty(bean, field.getName());
      if (StringUtils.isNotEmpty(message)) {
        return message;
      }
    }
    //属性基本验证完全，查看是否是类级验证，比如某些属性之间具有约束条件
    Annotation annotation = beanClass.getAnnotation(ClassLevelConstraint.class);
    if (annotation != null) {
      //使用默认的验证方法，具体验证规则在validatorBy中实现
      Set<ConstraintViolation<Object>> set = validator.validate(bean);
      return getMessage(set);
    }
    return StringUtils.EMPTY;
  }

  private static String ValidateProperty(Object bean, String fieldName) {
    Preconditions.checkNotNull(bean);
    Preconditions.checkNotNull(fieldName);

    Set<ConstraintViolation<Object>> set = validator.validateProperty(bean, fieldName);
    return getMessage(set);
  }

  private static String getMessage(Set<ConstraintViolation<Object>> set) {
    if (CollectionUtils.isEmpty(set)) {
      return StringUtils.EMPTY;
    }

    String message = StringUtils.EMPTY;
    for (ConstraintViolation<Object> constraintViolation : set) {
      if (StringUtils.isNotEmpty(constraintViolation.getMessage())) {
        message += " { " + constraintViolation.getMessage() + " } ";
      }
    }
    return message;
  }
}
