package ZzzAhu163.base.user;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.util.StringUtils;

/**
 * @author Zzz_Ahu_163
 * 用户角色枚举类型
 **/

@Slf4j
@Alias("UserRole")
@ToString
public enum UserRole {
    UNKNOWN(-1, "UNKNOWN", "未知用户"),
    ROLE_NORMAL(0, "ROLE_NORMAL", "正常用户");

    UserRole(int code, String name, String description) {
        this.code = code;
        this.name = name;
        this.description = description;
    }

    @Getter
    private int code;
    @Getter
    private String name;
    @Getter
    private String description;

    public static UserRole getUserRoleByCode(int code) {
        if (code < 0) {
            return UserRole.UNKNOWN;
        }
        for (UserRole role : UserRole.values()) {
            if (code == role.getCode()) {
                return role;
            }
        }
        return UserRole.UNKNOWN;
    }

    public static UserRole getUserRoleByName(String name) {
        if (StringUtils.isEmpty(name)) {
            return UserRole.UNKNOWN;
        }
        try {
            return UserRole.valueOf(name);
        } catch (Exception e) {
            log.error("failed getUserRoleByName {}", e.toString());
        }
        return UserRole.UNKNOWN;
    }

}
