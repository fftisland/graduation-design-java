package ZzzAhu163.base.menu;

import com.alibaba.fastjson.JSONObject;
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

    //由于枚举类型直接返回给前端的只是一个枚举类名，这里用一个JSON字符串方便前端使用
    private JSONObject subMenuInfoJson;

    private List<MenuItem> menuItemList;

    public SubMenu() {
        reset();
    }

    public SubMenu(SubMenuInfo subMenuInfo) {
        reset();
        if (subMenuInfo != null) {
            this.subMenuInfo = subMenuInfo;
            this.subMenuInfoJson = subMenuInfo.toJson();
        }
    }

    public void reset() {
        this.subMenuInfo = null;
        this.menuItemList = null;
        this.subMenuInfoJson = null;
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
