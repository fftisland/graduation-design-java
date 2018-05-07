package ZzzAhu163.springmvc.user;

import ZzzAhu163.base.baseResult.BaseResult;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserRole;
import ZzzAhu163.service.user.UserService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;

/**
 * @author Zzz_Ahu_163
 * User控制器类
 * **/

@RequestMapping("/user")
@Slf4j
@Controller("UserController")
public class UserController {
    @Resource
    UserService userService;

    @RequestMapping("/info")
    @ResponseBody
    public Object queryUser(HttpServletRequest request, HttpServletResponse response,
                            @RequestBody JSONObject json) {
        BaseResult result = BaseResult.getSuccessResult();
        try {
            String name = json.getString("name");
            if (StringUtils.isBlank(name)) {
                throw new Exception("name is blank");
            }
            User user = userService.querySimpleUserByName(name);
            result.setDataItems(user);
        } catch (Exception e) {
            log.error("/user/info : {}", e.toString());
            result = BaseResult.getFailedResult(e);
        }
        return result;
    }

    @RequestMapping("/register")
    @ResponseBody
    public Object loginOrRegister(HttpServletRequest request, HttpServletResponse response,
                                  @RequestBody JSONObject json) {
        BaseResult result = BaseResult.getSuccessResult();
        try {
            String username = json.getString("username");
            String password = json.getString("password");
            String email = json.getString("email");
            if (StringUtils.isBlank(username) || StringUtils.isBlank(password) || StringUtils.isBlank(email)) {
                throw new Exception("{username password email} can not be empty");
            }
            User user = userService.querySimpleUserByName(username);
            if (user != null) {
                throw new Exception("username existed");
            }
            user = userService.querySimpleUserByEmail(email);
            if (user != null) {
                throw new Exception("email existed");
            }
            //添加用户，默认是普通用户组
            user = new User();
            user.setName(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setUserRole(UserRole.ROLE_NORMAL);
            if (!userService.insertUser(user)) {
                throw new Exception("register failed");
            }
            //TODO:发送注册成功的邮件
        } catch (Exception e) {
            log.error("/user/register : {}", e.toString());
            result = BaseResult.getFailedResult(e);
        }
        return result;
    }
}
