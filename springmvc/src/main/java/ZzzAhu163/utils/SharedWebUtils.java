package ZzzAhu163.utils;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * @author ZzzAhu163
 * 主要提供操作web请求的工具
 **/
@Component("SharedWebUtils")
@Slf4j
public class SharedWebUtils {
  public static MyUserDetails getMyUserDetails(HttpServletRequest request) {
    if (request == null) {
      return null;
    }
    HttpSession session = request.getSession();
    SecurityContextImpl impl = (SecurityContextImpl) session.getAttribute("SPRING_SECURITY_CONTEXT");
    Authentication authentication = impl.getAuthentication();
    if (authentication == null) {
      return null;
    }
    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    return userDetails;
  }

  public static User getRequestUser(HttpServletRequest request) {
    MyUserDetails details = getMyUserDetails(request);
    if (details == null) {
      return null;
    }
    return details.getUser();
  }
}
