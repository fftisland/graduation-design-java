package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

@Data
public class NotNullButEmailBean implements BeanNeedValidate{
  @NotNullButEmail
  private String email1;

  @NotNullButEmail
  private String email2 = "om"; //这里有个坑 如果email2为空字符""则会通过@Email的验证，神奇。
}
