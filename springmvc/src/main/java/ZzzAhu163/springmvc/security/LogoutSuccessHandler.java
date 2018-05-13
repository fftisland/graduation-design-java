package ZzzAhu163.springmvc.security;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import ZzzAhu163.utils.CommonUtils.SharedStringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("LogoutSuccessHandler")
@Slf4j
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                Authentication authentication) throws IOException, ServletException {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
        request.setAttribute("userName", user.getName());
        request.getRequestDispatcher("/security/handle/logout").forward(request, response);
    }
}
