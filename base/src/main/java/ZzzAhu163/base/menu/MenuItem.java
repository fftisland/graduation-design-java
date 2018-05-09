package ZzzAhu163.base.menu;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.authority.AuthorityRole;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

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
}
