package ZzzAhu163.base.menu;

import ZzzAhu163.base.user.AuthorityRole;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 子菜单页
 * **/
@Alias("SubMenu")
@Data
public class SubMenu {
    private SubMenuInfo subMenuInfo;

    private List<AuthorityRole> authorityRoleList;

    private List<MenuItem> menuItemList;

    public SubMenu() {
        reset();
    }

    public void reset() {
        this.subMenuInfo = null;
        this.authorityRoleList = null;
        this.menuItemList = null;
    }
}
