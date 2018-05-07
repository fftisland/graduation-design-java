package ZzzAhu163.springmvc.security;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import ZzzAhu163.utils.SharedWebUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @author Zzz_Ahu_163
 * 登陆成功后的策略类
 * **/
@Component("LoginSuccessHandler")
@Slf4j
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        User user = SharedWebUtils.getRequestUser(request);
        log.info("login success : {}  {}", user.getName(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        List<GrantedAuthority> authorityList = (List<GrantedAuthority>) authentication.getAuthorities();
        log.info("权限为：{}", authorityList);
        //TODO:登录成功，重定向到/security/handle
        request.setAttribute("user", user);
        request.getRequestDispatcher("/security/handle/success").forward(request, response);
    }
}
