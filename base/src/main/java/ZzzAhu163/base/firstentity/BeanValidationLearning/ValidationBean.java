package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;

/**
 * 学习Java Bean Validation的使用
 *@author ZzzAhu163
 * **/

@Data
public class ValidationBean implements BeanNeedValidate{
  @NotNull(message = "NotNull属性不能为空")
  private String NotNUll;

  @Email(message = "Email属性必须为邮箱格式")
  @NotNull(message = "Email必须不能为空")
  private String email;
}
