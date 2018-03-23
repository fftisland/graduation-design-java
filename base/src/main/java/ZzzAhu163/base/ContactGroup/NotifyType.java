package ZzzAhu163.base.ContactGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

/**
 * @author ZzzAhu163
 * 当多个实体都含有联系人组时进行的合并策略
 **/
@Alias("NotifyType")
@Getter
@AllArgsConstructor
public enum NotifyType {
  //三种邮件通知策略
  DEFAULT_NOTIFY(0, "DEFAULT_NOTIFY", "默认通知"),
  INCLUDE_NOTIFY(1, "INCLUDE_NOTIFY", "包含通知"),
  EXCLUDE_NOTIFY(2, "EXCLUDE_NOTIFY", "仅其通知");

  private int code;
  private String name;
  private String description;
}
