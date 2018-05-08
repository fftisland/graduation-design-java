package ZzzAhu163.service.menu;

import ZzzAhu163.base.menu.Menu;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.menu.filter.MenuQueryFilter;
import ZzzAhu163.mapper.menu.MenuMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    @Resource
    MenuMapper menuMapper;

    @Override
    public boolean insertMenuItem(MenuItem menuItem) {
        if (menuItem == null || menuItem.getId() > 0) {
            return false;
        }
        menuMapper.insertMenuItem(menuItem);
        return menuItem.getId() > 0 ? true : false;
    }

    @Override
    public int queryMenuItemListCount(MenuQueryFilter filter) {
        if (filter == null) {
            return 0;
        }
        return menuMapper.queryMenuItemListCountByFilter(filter);
    }

    @Override
    public List<MenuItem> queryMenuItemList(MenuQueryFilter filter) {
        int count = queryMenuItemListCount(filter);
        if (count <= 0) {
            return null;
        }
        List<MenuItem> list = menuMapper.queryMenuItemListByFilter(filter);
        return CollectionUtils.isEmpty(list) ? null : list;
    }

    @Override
    public MenuItem queryMenuItemById(int id) {
        MenuQueryFilter filter = new MenuQueryFilter(id);
        List<MenuItem> list = queryMenuItemList(filter);
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public MenuItem queryMenuItemByRouterUrl(String routerUrl) {
        MenuItem menuItem = new MenuItem();
        menuItem.setRouterUrl(routerUrl);
        MenuQueryFilter filter = new MenuQueryFilter(menuItem);
        List<MenuItem> list = queryMenuItemList(filter);
        if (list == null) {
            return null;
        }

        return list.get(0);
    }

    @Override
    public List<MenuItem> queryMenuItemListByMenuInfo(SubMenuInfo subMenuInfo) {
        if (subMenuInfo == null) {
            return null;
        }
        MenuItem menuItem = new MenuItem();
        menuItem.setMenuCode(subMenuInfo.getCode());
        MenuQueryFilter filter = new MenuQueryFilter(menuItem);
        return queryMenuItemList(filter);
    }

    @Override
    public boolean deleteMenuItemById(int id) {
        return menuMapper.deleteMenuItemById(id) == 1 ? true : false;
    }

    @Override
    public boolean updateMenuItem(MenuItem menuItem) {
        return menuMapper.updateMenuItem(menuItem) == 1 ? true : false;
    }
}
