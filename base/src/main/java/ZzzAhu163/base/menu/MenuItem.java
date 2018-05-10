package ZzzAhu163.base.menu;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.user.User;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 菜单具体项目
 * **/
@Alias("MenuItem")
@Data
@ToString(callSuper = true)
public class MenuItem extends BaseObjectEx{
    private int menuCode;

    private String routerUrl;

    private String iconType;

    //TODO:子菜单需要的权限
    private List<AuthorityRole> itemAuthorities;

    public MenuItem() {
        super();
    }

    public MenuItem(int id) {
        super(id);
    }

    public void reset() {
        super.reset();
        this.menuCode = 0;
        this.routerUrl = null;
        this.iconType = null;
        this.itemAuthorities = null;
    }

    public void addAuthority(AuthorityRole role) {
        if (role == null || StringUtils.isBlank(role.getAuthority())) {
            return;
        }
        if (itemAuthorities == null) {
            itemAuthorities = new ArrayList<>();
        }
        //去重
        for (AuthorityRole temp : itemAuthorities) {
            if (temp.equals(role)) {
                return;
            }
        }
        itemAuthorities.add(role);
    }

    public boolean checkAuthority(User user) {
        if (CollectionUtils.isEmpty(itemAuthorities)) {
            return true;
        }
        if (user == null || CollectionUtils.isEmpty(user.getAuthorities())) {
            return false;
        }
        if (user.hasAuthority("ROLE_ALL_ALL_ALL")) {
            return true;
        }
        for (AuthorityRole role : itemAuthorities) {
            for (GrantedAuthority userRole : user.getAuthorities()) {
                if (role.equals(userRole)) {
                    return true;
                }
            }
        }
        return false;
    }
}
