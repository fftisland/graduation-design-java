package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 隐式的分组，这个时候我们就不能直接把约束定义在属性上了，
 * 而是需要定义在他的get方法上
 * **/
@Data
public class UntypedDivideGroupBean implements GroupA, GroupB, BeanNeedValidate{
  private String groupA;

  private String groupB;

  private String defaultGroup;

  @NotNull(message = "default 不能为 null")
  public String getDefaultGroup() {
    return defaultGroup;
  }

  @Override
  public String getGroupA() {
    return groupA;
  }

  @Override
  public String getGroupB() {
    return groupB;
  }
}
