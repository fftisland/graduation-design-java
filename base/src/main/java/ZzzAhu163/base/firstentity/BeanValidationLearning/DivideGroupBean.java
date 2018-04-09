package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用来测试分组约束
 * **/
@Data
public class DivideGroupBean implements BeanNeedValidate{
  @NotNull(message = "groupDefault can not be null")
  private String groupDefault;

  @NotNull(message = "groupA can not be null", groups = GroupA.class)
  private String groupA;

  @NotNull(message = "groupB can not be null", groups = GroupB.class)
  private String groupB;
}
