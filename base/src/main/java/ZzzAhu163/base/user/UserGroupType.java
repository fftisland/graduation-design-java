package ZzzAhu163.base.user;

import lombok.Getter;
import lombok.ToString;
import lombok.Value;

/**
 * @author ZzzAhu163
 * 用户组类型
 **/

@Getter
@ToString
public enum UserGroupType{

  GROUP_USER(0, "GROUP_USER", "普通用户组"),
  GROUP_ADMIN(1, "GROUP_ADMIN", "管理员"),
  GROUP_SUPER_ADMIN(2, "GROUP_SUPER_ADMIN", "超级管理员");

  UserGroupType(int code, String name, String description) {
    this.code = code;
    this.name = name;
    this.description = description;
  }

  private int code;
  private String name;
  private String description;
}
