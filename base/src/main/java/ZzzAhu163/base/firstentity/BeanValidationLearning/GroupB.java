package ZzzAhu163.base.firstentity.BeanValidationLearning;

import javax.validation.constraints.NotNull;

public interface GroupB {
  @NotNull(message = "groupB 不能为 null")
  String getGroupB();
}
