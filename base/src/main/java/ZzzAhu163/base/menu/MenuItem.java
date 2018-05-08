package ZzzAhu163.base.menu;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

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
    }
}
