package ZzzAhu163.base.baseObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.ibatis.type.Alias;

/**
 * @author  ZzzAhu163
 * 我将，目录，链接，标签等都表示为某种类型的实体
 **/
@AllArgsConstructor
@Getter
@Alias("EntityType")
public enum EntityType {
  UNKNOWN(0, "未知类型", "默认情况下就是未知类型，表示不参与数据库索引"),
  MENU(1, "菜单", "菜单主页"),
  MENU_ITEM(2, "菜单子页", "菜单页中的具体子页");

  private int code;
  private String name;
  private String description;
}
