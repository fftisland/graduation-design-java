package ZzzAhu163.service.menu;

import ZzzAhu163.base.authority.AuthorityQueryFilter;
import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.menu.Menu;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.menu.filter.MenuQueryFilter;
import ZzzAhu163.mapper.menu.MenuMapper;
import ZzzAhu163.service.user.AuthorityService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
@Service("menuService")
public class MenuServiceImpl implements MenuService{
    @Resource
    private MenuMapper menuMapper;
    @Resource
    private AuthorityService authorityService;

    @Override
    public boolean insertMenuItem(MenuItem menuItem) {
        if (menuItem == null || menuItem.getId() > 0) {
            return false;
        }
        menuMapper.insertMenuItem(menuItem);
        if (menuItem.getId() <= 0) {
            return false;
        }
        if (CollectionUtils.isEmpty(menuItem.getItemAuthorities())) {
            return true;
        }
        for (AuthorityRole role : menuItem.getItemAuthorities()) {
            if (role == null || StringUtils.isBlank(role.getAuthority())) {
                continue;
            }
            AuthorityRole temp = authorityService.queryAuthorityRoleByName(role.getAuthority());
            if (temp != null) {
                role = temp;
            } else {
                authorityService.insertAuthorityRole(role);
                if (role.getId() <= 0) {
                    return false;
                }
            }
        }
        return authorityService.insertDataAuthorityList(DataType.MENU_ITEM, menuItem.getId(), menuItem.getItemAuthorities());
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
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        for (MenuItem item : list) {
            item.setItemAuthorities(authorityService.queryDataAuthorityList(new AuthorityQueryFilter(DataType.MENU_ITEM, item.getId())));
        }
        return list;
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
