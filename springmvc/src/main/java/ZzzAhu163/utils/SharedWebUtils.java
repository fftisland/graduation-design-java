package ZzzAhu163.utils;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @author ZzzAhu163
 * 主要提供操作web请求的工具
 **/
@Component("SharedWebUtils")
@Slf4j
public class SharedWebUtils {
  public static MyUserDetails getMyUserDetails(@NonNull HttpServletRequest request) {
    Principal principal = request.getUserPrincipal();
    if (principal instanceof UsernamePasswordAuthenticationToken) {
      UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)principal;
      Object obj = token.getDetails();
      if (obj != null && obj instanceof MyUserDetails) {
        return (MyUserDetails)obj;
      }
    }
    return null;
  }

  public static User getRequestUser(HttpServletRequest request) {
    MyUserDetails details = getMyUserDetails(request);
    if (details == null) {
      return null;
    }
    return details.getUser();
  }
}
