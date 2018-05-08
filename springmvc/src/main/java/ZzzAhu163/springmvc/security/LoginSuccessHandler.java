package ZzzAhu163.springmvc.security;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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
        MyUserDetails details = (MyUserDetails) authentication.getPrincipal();
        User user = details.getUser();
        request.setAttribute("user", user);
        request.getRequestDispatcher("/security/handle/success").forward(request, response);
    }
}
