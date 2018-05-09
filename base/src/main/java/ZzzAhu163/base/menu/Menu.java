package ZzzAhu163.base.menu;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 菜单页
 * **/
@Alias("Menu")
@Data
public class Menu {
    public List<SubMenu> subMenuList;

    public Menu() {
        reset();
    }

    public void reset() {
        this.subMenuList = null;
    }

    public void addSubMenu(SubMenu subMenu) {
        if (this.subMenuList == null) {
            subMenuList = new ArrayList<>();
        }
        subMenuList.add(subMenu);
    }
}
