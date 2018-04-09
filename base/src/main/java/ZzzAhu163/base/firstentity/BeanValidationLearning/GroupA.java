package ZzzAhu163.base.firstentity.BeanValidationLearning;

import javax.validation.constraints.NotNull;

/**
 * 在给约束进行分组时，分组的标志为接口
 * **/
public interface GroupA {
  @NotNull(message = "groupA 不能为 null")
  String getGroupA();
}
