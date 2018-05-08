package ZzzAhu163.springmvc.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Zzz_Ahu_163
 * 登陆失败的策略类
 * **/
@Component("LoginFailedHandler")
@Slf4j
public class LoginFailedHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {
        request.setAttribute("exception", e);
        request.getRequestDispatcher("/security/handle/failed").forward(request, response);
    }
}
