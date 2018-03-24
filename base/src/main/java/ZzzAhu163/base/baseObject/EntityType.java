package ZzzAhu163.base.baseObject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;

import javax.swing.text.html.parser.Entity;

/**
 * @author ZzzAhu163
 * 我将，目录，链接，标签等都表示为某种类型的实体
 **/
@AllArgsConstructor
@Getter
@Alias("EntityType")
@Slf4j
public enum EntityType {
    UNKNOWN(-1, "未知类型", "默认情况下就是未知类型，表示不参与数据库索引"),
    MENU(0, "菜单", "菜单主页"),
    MENU_ITEM(1, "菜单子页", "菜单页中的具体子页");

    private int code;
    private String name;
    private String description;

    public static EntityType getEntityTypeById(int code) {
        if (code >= 0) {
            for (EntityType type : EntityType.values()) {
                if (type.getCode() == code) {
                    return type;
                }
            }
        }
        return EntityType.UNKNOWN;
    }

    public static EntityType getEntityTypeByName(String name) {
        try {
            if (name != null) {
                return EntityType.valueOf(name);
            }
        } catch (Exception e) {
            log.error("getEntityTypeByName failed {}", e.toString());
        }
        return EntityType.UNKNOWN;
    }
}
