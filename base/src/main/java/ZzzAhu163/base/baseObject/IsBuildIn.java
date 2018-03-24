package ZzzAhu163.base.baseObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public enum IsBuildIn {
  BUILD_IN(0, "内置类型", "从开始就存在的，不是由用户添加的"),
  NOT_BUILD_IN(1, "非内置类型", "某些情况下动态生成的");

  private int code;
  private String name;
  private String description;
}
