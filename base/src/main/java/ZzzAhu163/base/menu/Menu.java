package ZzzAhu163.base.menu;

import lombok.Data;
import org.apache.ibatis.type.Alias;

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

    //TODO:根据USer处理当前subMenuList哪些可以回显给前端
}
