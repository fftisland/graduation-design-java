package ZzzAhu163.base.menu;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.user.User;
import lombok.Data;
import lombok.ToString;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;

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

    public boolean checkUserAuthority(User user) {
        if (user == null) {
            return false;
        }
        if (CollectionUtils.isEmpty(itemAuthorities) ||  user.hasAuthority("ROLE_ALL_ALL_ALL")) {
            return true;
        }
        for (GrantedAuthority grantedAuthority : user.getAuthorities()) {
            for (AuthorityRole role : itemAuthorities) {
                if (role.equals(grantedAuthority)) {
                    return true;
                }
            }
        }
        return false;
    }
}
