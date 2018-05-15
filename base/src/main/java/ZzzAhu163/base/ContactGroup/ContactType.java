package ZzzAhu163.base.ContactGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

/**
 *@author Zzz_Ahu_163
 * 联系人组的类型，比如前端，服务端，客户端等
 * **/
@Slf4j
@Getter
@AllArgsConstructor
public enum ContactType {
    WITHOUT_TYPE(0, "WITHOUT_TYPE", "普通联系人组，不需要标注特别类型"),
    BACK_END(1, "BACK_END", "服务端"),
    FORE_EDN(2, "FORE_EDN", "前端"),
    CLIENT_END(3, "CLIENT_END", "客户端"),
    CS_BASE(4, "CS_BASE", "计算机基础"),
    ARTICLE(5, "ARTICLE", "文章链接");

    private int code;
    private String name;
    private String description;

    public static ContactType getContactTypeByCode(int code) {
        if (code <= 0) {
            return null;
        }
        for (ContactType type : ContactType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }

    public static ContactType getContactTypeByName(String name) {
        try {
            if (StringUtils.isBlank(name)) {
                return null;
            }
            return ContactType.valueOf(name);
        } catch (Exception e) {
            log.error("getContactTypeByName Error : {}", e.toString());
        }
        return null;
    }
}
