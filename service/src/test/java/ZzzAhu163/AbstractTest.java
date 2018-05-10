package ZzzAhu163;

import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.authority.DataType;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroupType;
import ZzzAhu163.service.menu.MenuService;
import ZzzAhu163.service.user.AuthorityService;
import ZzzAhu163.service.user.UserGroupService;
import ZzzAhu163.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:service-spring-config.xml")
@Slf4j
public class AbstractTest {
    @Resource
    private UserGroupService userGroupService;
    @Resource
    private UserService userService;
    @Resource
    private AuthorityService authorityService;
    @Resource
    private MenuService menuService;

    /**
     * 插入User到UserGroup
     * **/
    @Test
    public void insertUserIntoGroup() {
        User user = userService.queryUserByName("赵子彰1");
        boolean result = userGroupService.insertUserIntoUserGroup(user, UserGroupType.GROUP_USER);
        log.info("插入结果：{}", result);
    }

    /**
     * 给UserGroup赋予UrlPattern或者UrlRouter的权限
     * 具体权限列表在：springMvc/doc目录下的 UserGroup_Role_Map中记录着
     * **/
    @Test
    public void insertUserGroupAuthority() {
        String roleName = "ROLE_MENU_QUERY";
        int userId = userGroupService.queryUserGroupIdByType(UserGroupType.GROUP_USER);
        AuthorityRole role = authorityService.queryAuthorityRoleByName(roleName);
        if (role == null) {
            role = new AuthorityRole(roleName);
            role.setDescription("/menu/query");
            authorityService.insertAuthorityRole(role);
        }
        boolean result = authorityService.insertDataAuthority(DataType.USER_GROUP, userId, role);
        log.info("插入结果：{}", result);
    }

    /**
     * 给GROUP_USER_ADMIN用户组的用户赋予个人权限
     * **/
    @Test
    public void insertUserPersonalAuthority() {
        User user = userService.queryUserByName("赵子彰1");
        AuthorityRole role = authorityService.queryAuthorityRoleByName("ROLE_USER_ADMIN");
        boolean result = authorityService.insertDataAuthority(DataType.USER, user.getId(), role);
        log.info("插入结果: {}", result);
    }

    /**
     * 添加MenuItem和其对应的权限到数据库
     * router_url需要在前端进行初始化
     **/
    @Test
    public void insertMenuItem() {
        MenuItem menuItem = new MenuItem();
        menuItem.setName("菜单列表");
        menuItem.setIconType("email");
        menuItem.setMenuCode(SubMenuInfo.MENU_MANAGE.getCode());
        menuItem.setRouterUrl("/menumanage/list");
        menuItem.addAuthority(new AuthorityRole("ROLE_MENU_MANAGE_LIST",
                "前端路由:/menumanage/list"));
        boolean result = menuService.insertMenuItem(menuItem);
        log.info("插入结果: {}", result);
    }
}
