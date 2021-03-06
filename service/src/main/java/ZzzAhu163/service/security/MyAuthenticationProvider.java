package ZzzAhu163.service.security;

import com.alibaba.druid.util.StringUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.annotation.Resource;


/**
 * @author ZzzAhu163
 * 自定义的Provider
 **/
@Data
@Slf4j
public class MyAuthenticationProvider implements AuthenticationProvider {
  @Resource
  private MyUserDetailService myUserDetailService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
    UserDetails userDetails = myUserDetailService.loadUserByUsername(token.getName());
    if (null == userDetails) {
      throw new UsernameNotFoundException("没有找到用户名为{" + token.getName() + "}的用户");
    }
    if (!StringUtils.equals(userDetails.getPassword(), token.getCredentials().toString())) {
      throw new BadCredentialsException("用户{" + token.getName() + "} 密码输入错误{" + token.getCredentials().toString() + "}");
    }
    //TODO:查看用户是否具有登陆权限，没有登陆权限直接抛出异常
    return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
  }

  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class.equals(aClass);
  }
}
