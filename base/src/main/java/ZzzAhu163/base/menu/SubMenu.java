package ZzzAhu163.base.menu;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 子菜单页
 * **/
@Alias("SubMenu")
@Data
public class SubMenu {
    private SubMenuInfo subMenuInfo;

    private List<MenuItem> menuItemList;

    public SubMenu() {
        reset();
    }

    public SubMenu(SubMenuInfo subMenuInfo) {
        reset();
        this.subMenuInfo = subMenuInfo;
    }

    public void reset() {
        this.subMenuInfo = null;
        this.menuItemList = null;
    }

    public void addMenuItem(MenuItem menuItem) {
        if (menuItem == null) {
            return;
        }
        if (menuItemList == null) {
            menuItemList = new ArrayList<>();
        }
        menuItemList.add(menuItem);
    }
}
