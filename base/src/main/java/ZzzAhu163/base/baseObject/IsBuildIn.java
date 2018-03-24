package ZzzAhu163.base.baseObject;

import ZzzAhu163.base.user.UserGroupType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.Is;

/**
 * @author Zzz_Ahu_163
 * 标记某些数据是内置还是后来添加，内置的不允许任何人通过代码进行修改
 **/

@Slf4j
@AllArgsConstructor
@Getter
public enum IsBuildIn {
  BUILD_IN(0, "内置类型", "从开始就存在的，不是由用户添加的"),
  NOT_BUILD_IN(1, "非内置类型", "某些情况下动态生成的");

  private int code;
  private String name;
  private String description;

  public static IsBuildIn getIsBuildInById(int code) {
    if (code < 0) {
      return null;
    }
    for (IsBuildIn isBuildIn : IsBuildIn.values()) {
      if (isBuildIn.getCode() == code) {
        return isBuildIn;
      }
    }
    return null;
  }

  public static IsBuildIn getIsBuildInByName(@NonNull String name) {
    try {
      return IsBuildIn.valueOf(name);
    } catch (Exception e) {
      log.error("getIsBuildInByName failed {}", e.toString());
    }
    return null;
  }
}
