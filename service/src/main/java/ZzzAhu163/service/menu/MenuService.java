package ZzzAhu163.service.menu;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.menu.filter.MenuQueryFilter;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface MenuService {
    boolean insertMenuItem(MenuItem menuItem);

    int queryMenuItemListCount(MenuQueryFilter filter);

    List<MenuItem> queryMenuItemList(MenuQueryFilter filter);

    MenuItem queryMenuItemById(int id);

    MenuItem queryMenuItemByRouterUrl(String routerUrl);

    List<MenuItem> queryMenuItemListByMenuInfo(SubMenuInfo subMenuInfo);

    boolean deleteMenuItemById(int id);

    boolean updateMenuItem(MenuItem menuItem);
}
