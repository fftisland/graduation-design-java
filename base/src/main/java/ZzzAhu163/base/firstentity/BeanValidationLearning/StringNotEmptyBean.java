package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

/**用来验证我们自定义的StringNotEmpty注解**/
@Data
public class StringNotEmptyBean implements BeanNeedValidate{
  @StringNotEmpty(message = "field1 is not allowed empty")
  private String field1;

  @StringNotEmpty(message = "field2 is not allowed empty")
  private String field2;
}
