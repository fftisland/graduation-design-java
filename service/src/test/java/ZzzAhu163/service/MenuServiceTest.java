package ZzzAhu163.service;

import ZzzAhu163.AbstractTest;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.menu.filter.MenuQueryFilter;
import ZzzAhu163.base.user.User;
import ZzzAhu163.service.menu.MenuService;
import ZzzAhu163.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
public class MenuServiceTest extends AbstractTest {
    @Resource
    private MenuService menuService;
    @Resource
    private UserService userService;

    @Test
    public void insertTest() {
        MenuItem menuItem = new MenuItem();
        menuItem.setMenuCode(SubMenuInfo.AUTHORITY_MANAGE.getCode());
        menuItem.setRouterUrl("#/bbbbb");
        menuItem.setIconType("email");
        menuItem.setName("测试用例");
        boolean result = menuService.insertMenuItem(menuItem);
        log.info("插入结果 {}  自增主键 {}", result, menuItem.getId());
    }

    @Test
    public void deleteTest() {
        int id = 1;
        boolean result = menuService.deleteMenuItemById(id);
         log.info("删除结果 : {}", result);
    }

    @Test
    public void queryByFilterTest() {
        MenuItem menuItem = new MenuItem();
        menuItem.setMenuCode(SubMenuInfo.AUTHORITY_MANAGE.getCode());
        menuItem.setRouterUrl("#/bbbbb");
        menuItem.setIconType("email");
        menuItem.setName("测试用例");
        MenuQueryFilter filter = new MenuQueryFilter(menuItem);

        int count = menuService.queryMenuItemListCount(filter);
        log.info("结果条数{}", count);
        if (count > 0) {
            List<MenuItem> list = menuService.queryMenuItemList(filter);
            log.info("查询结果 : {}", list);
        }
    }

    @Test
    public void queryByIdAndUrlTest() {
        int id = 4;
        String url = "#/layout";
        MenuItem m1 = menuService.queryMenuItemById(id);
        MenuItem m2 = menuService.queryMenuItemByRouterUrl(url);
        log.info("query by id : {}", m1);
        log.info("query by url : {}", m2);
    }

    @Test
    public void queryBySubMenuInfo() {
        List<MenuItem> list = menuService.queryMenuItemListByMenuInfo(SubMenuInfo.MENU_MANAGE);
        if (list != null) {
            log.info("查询结果: {} {}", list.size(), list);
        }
    }

    @Test
    public void updateMenuInfo() {
        int id = 2;
        MenuItem menuItem = menuService.queryMenuItemById(id);
        log.info("更新前: {}", menuItem);
        menuItem.setName("更新用例");
        boolean result = menuService.updateMenuItem(menuItem);
        log.info("更新结果 : {}", result);
    }

    @Test
    public void getUserMenuTest() {
        String name = "赵子彰1";
        User user = userService.queryUserByName(name);
        log.info("用户权限: {}", user.getAuthorityForLog());
    }
}
