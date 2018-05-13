package ZzzAhu163.springmvc.security;

import ZzzAhu163.base.baseResult.BaseResult;
import ZzzAhu163.base.user.User;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import ZzzAhu163.utils.SharedWebUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Zzz_Ahu_163
 * SpringSecurity框架能够拦截URL，但是没有进行Response的返回
 * 如果想返回信息给前端，就在这里进行
 * **/
@Controller("HandleController")
@Slf4j
@RequestMapping("/security/handle")
public class HandleController {

    /**
     * 返回登陆成功的信息
     * **/
    @RequestMapping("/success")
    @ResponseBody
    public Object loginSuccessResult(HttpServletRequest request, HttpServletResponse response) {
        BaseResult result = BaseResult.getSuccessResult();
        User user = (User) request.getAttribute("user");
        log.info(" {} 登录认证成功 : {}", user.getName(), user.getAuthorityForLog());
        result.setDataItems(user);
        result.setMsg("LOGIN_SUCCESS");
        return result;
    }

    /**
     * 返回登陆失败的信息
     * **/
    @RequestMapping("/failed")
    @ResponseBody
    public Object loginFailedResult(HttpServletRequest request, HttpServletResponse response) {
        BaseResult result = BaseResult.getSuccessResult();
        Exception e = (Exception) request.getAttribute("exception");
        log.info("登录认证失败 : {}", e.toString());
        result.setDataItems(e.toString());
        result.setMsg("LOGIN_FAILED");
        return result;
    }

    /**
     * 返回注销成功的信息
     * **/
    @RequestMapping("/logout")
    @ResponseBody
    public Object logoutSuccessResult(HttpServletRequest request, HttpServletResponse response) {
        BaseResult result = BaseResult.getSuccessResult();
        String userName = (String) request.getAttribute("userName");
        log.info("{} 退出登录 {}", userName, SharedStringUtil.formatTime("yyyy-MM-dd HH:mm:ss"));
        result.setDataItems(userName);
        result.setMsg("LOGOUT_SUCCESS");
        return result;
    }
}
