package ZzzAhu163.base.user;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ZzzAhu163
 * 用户组类型
 **/

@Getter
@ToString
@Slf4j
@AllArgsConstructor
public enum UserGroupType {
  GROUP_USER(0, "GROUP_USER", "普通用户组"),
  GROUP_ADMIN(1, "GROUP_ADMIN", "管理员组"),
  GROUP_SUPER_ADMIN(2, "GROUP_SUPER_ADMIN", "超级管理员组");

  private int code;
  private String name;
  private String description;

  public static UserGroupType getUserGroupTypeById(int code) {
    if (code < 0) {
      return null;
    }
    for (UserGroupType userGroupType : UserGroupType.values()) {
      if (userGroupType.getCode() == code) {
        return userGroupType;
      }
    }
    return null;
  }

  public static UserGroupType getUserGroupTypeByName(@NonNull String name) {
    try {
      return UserGroupType.valueOf(name);
    } catch (Exception e) {
      log.error("getUserGroupTypeByName failed {}", e.toString());
    }
    return null;
  }
}
