package ZzzAhu163.base.firstentity.BeanValidationLearning;

import lombok.Data;

/**
 * 验证多值约束的Bean
 * **/
@Data
public class MultipartValueBean implements BeanNeedValidate{
  @SubStrContainedCheck.List({
    @SubStrContainedCheck(subStr = "这是aaa", message = "不包'这是aaa'这个子串"),
    @SubStrContainedCheck(subStr = "父字", message = "匹配不到'父字'这个子串")
  })
  private String parentStr = "这是一个父字符串";
}
