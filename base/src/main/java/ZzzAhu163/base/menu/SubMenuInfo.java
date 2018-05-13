package ZzzAhu163.base.menu;

import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.user.User;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 主菜单，不用存到数据库，直接用枚举类型列出就行
 * **/
@AllArgsConstructor
@Getter
@Slf4j
public enum SubMenuInfo {
    USER_MANAGE(1, "用户管理", "用户相关操作", "person",
            SharedStringUtil.convertToAuthorityRole("ROLE_USER_ADMIN", "ROLE_ALL_ALL_ALL")),
    AUTHORITY_MANAGE(2, "权限管理", "权限相关操作", "key",
            SharedStringUtil.convertToAuthorityRole("ROLE_AUTHORITY_ADMIN", "ROLE_ALL_ALL_ALL")),
    MENU_MANAGE(3, "菜单管理", "菜单相关操作", "android-menu",
            SharedStringUtil.convertToAuthorityRole("ROLE_MENU_ADMIN", "ROLE_ALL_ALL_ALL"));

    private int code;

    private String name;

    private String description;

    private String iconType;

    private List<AuthorityRole> authorityRoleList;

    public boolean checkUserAuthority(User user) {
        //user不能为空说明一定要是登陆状态
        if (user == null) {
            return false;
        }
        //authorityRoleList为空说明不需要任何权限
        if (CollectionUtils.isEmpty(authorityRoleList) || user.hasAuthority("ROLE_ALL_ALL_ALL")) {
            return true;
        }
        //由于已经验证了authorityRoleList可能为空，所以将其放在内部循环
        for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
            for (AuthorityRole role : authorityRoleList) {
                if (role.equals(grantedAuthority)) {
                    return true;
                }
            }
        }
        return false;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("subMenuName", getName());
        json.put("subMenuIcon", getIconType());
        json.put("subMenuDescription", getDescription());
        json.put("subMenuCode", getCode());

        return json;
    }
}
