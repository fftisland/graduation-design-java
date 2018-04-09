package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * 用来检验如何进行级联验证
 * **/
@Data
public class CascadeBean implements BeanNeedValidate {
  @NotNull(message = "CasecadeBean的属性不能为null")
  private String casecadeString;

  private StringNotEmptyBean stringNotEmpty = new StringNotEmptyBean();

  @Valid
  private NotNullButEmailBean notNullButEmailBean = new NotNullButEmailBean();
}
