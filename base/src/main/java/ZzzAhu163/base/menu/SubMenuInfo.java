package ZzzAhu163.base.menu;

import ZzzAhu163.base.user.AuthorityRole;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 主菜单，不用存到数据库，直接用枚举类型列出就行
 * **/
@AllArgsConstructor
@Getter
@Slf4j
public enum SubMenuInfo {
    USER_MANAGE(1, "用户管理", "用户相关操作", null,
            SharedStringUtil.convertToAuthorityRole("ROLE_USER_ADMIN", "ROLE_ALL_ALL_ALL")),
    AUTHORITY_MANAGE(2, "权限管理", "权限相关操作", null,
            SharedStringUtil.convertToAuthorityRole("ROLE_AUTHORITY_ADMIN", "ROLE_ALL_ALL_ALL")),
    MENU_MANAGE(3, "菜单管理", "菜单相关操作", null,
            SharedStringUtil.convertToAuthorityRole("ROLE_MENU_ADMIN", "ROLE_ALL_ALL_ALL"));

    private int code;

    private String name;

    private String description;

    private String icon_type;

    private List<AuthorityRole> authorityRoleList;
}
