package ZzzAhu163.base.authority;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;

/**
 * @author Zzz_Ahu_163
 * 重构权限系统，对权限进行统一管理
 * **/
@Slf4j
@AllArgsConstructor
@Getter
public enum DataType {
    USER(1, "User", "数据类型为User"),
    USER_GROUP(2, "UserGroup", "数据类型为UserGroup"),
    MENU_ITEM(3, "MenuItem", "数据类型为MenuItem");

    private int code;

    private String name;

    private String description;

    public static DataType getDataTypeByCode(int code) {
        if (code <= 0) {
            return null;
        }
        for (DataType dataType : DataType.values()) {
            if (dataType.getCode() == code) {
                return dataType;
            }
        }
        return null;
    }
}
