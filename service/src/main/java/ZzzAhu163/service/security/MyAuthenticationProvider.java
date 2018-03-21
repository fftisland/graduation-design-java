package ZzzAhu163.service.security;

import com.alibaba.druid.util.StringUtils;
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
public class MyAuthenticationProvider implements AuthenticationProvider {
  @Resource
  private MyUserDetailService myUserDetailService;

  /**
   * SpringSecurity会将前端用户名和密码封装成一个UserDetails赋值给authentication的principal
   * 不过我们这里使用较为简单的实现类UsernamePasswordAuthenticationToken
   **/
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
    UserDetails userDetails = myUserDetailService.loadUserByUsername(token.getName());
    /**注意下面两个异常千万别自己处理，否则Security框架将截获不到验证结果**/
    if (null == userDetails) {
      throw new UsernameNotFoundException("没有找到用户名为{" + token.getName() + "}的用户");
    }
    if (!StringUtils.equals(userDetails.getPassword(), token.getCredentials().toString())) {
      throw new BadCredentialsException("用户{" + token.getName() + "} 密码输入错误{" + token.getCredentials().toString() + "}")
    }

    return new UsernamePasswordAuthenticationToken(userDetails, userDetails.getPassword(), userDetails.getAuthorities());
  }


  /**
   * 认证提供类型
   **/
  @Override
  public boolean supports(Class<?> aClass) {
    return UsernamePasswordAuthenticationToken.class.equals(aClass);
  }
}
