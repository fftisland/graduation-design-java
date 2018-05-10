package ZzzAhu163.springmvc.menu;

import ZzzAhu163.base.baseResult.BaseResult;
import ZzzAhu163.base.menu.Menu;
import ZzzAhu163.base.menu.MenuItem;
import ZzzAhu163.base.menu.SubMenu;
import ZzzAhu163.base.menu.SubMenuInfo;
import ZzzAhu163.base.user.User;
import ZzzAhu163.service.menu.MenuService;
import ZzzAhu163.service.user.UserService;
import ZzzAhu163.utils.SharedWebUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/

@Slf4j
@Controller("MenuController")
@RequestMapping(value = "/menu")
public class MenuController {
    @Resource
    UserService userService;
    @Resource
    MenuService menuService;

    @RequestMapping(value = "/query")
    @ResponseBody
    public Object initMenuItems(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody JSONObject json) {
        BaseResult baseResult = BaseResult.getSuccessResult();
        try {
            String username = json.getString("username");
            User user = null;
            if (StringUtils.isBlank(username) || (user = SharedWebUtils.getRequestUser(request)) == null) {
                throw new Exception("用户未登录");
            }
            log.info("用户加载菜单: {}", user);
            Menu menu = getMenu(user);
            baseResult.setDataItems(menu);
        } catch (Exception e) {
            log.error("/menu/query : {}", e.toString());
            baseResult = BaseResult.getFailedResult(e);
        }
        return baseResult;
    }

    private Menu getMenu(User user) {
        if (user == null) {
            return null;
        }
        Menu menu = new Menu();
        List<GrantedAuthority> userAuthorities = user.getAuthorities();
        for (SubMenuInfo subMenuInfo : SubMenuInfo.values()) {
            SubMenu subMenu = new SubMenu(subMenuInfo);
            if (subMenuInfo.checkUserAuthority(user)) {
                List<MenuItem> list = menuService.queryMenuItemListByMenuInfo(subMenuInfo);
                for (MenuItem item : list) {
                    if (item.checkAuthority(user)) {
                        subMenu.addMenuItem(item);
                    }
                }
                menu.addSubMenu(subMenu);
            }
        }
        return menu;
    }
}
