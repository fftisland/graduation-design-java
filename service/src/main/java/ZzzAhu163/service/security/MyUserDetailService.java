package ZzzAhu163.service.security;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserRole;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import ZzzAhu163.service.user.UserService;
import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Slf4j
@Data
@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {
  @Resource
  private UserService userService;

  /*自定义loadUserByUsername方法，根据用户名获取UserDetails，主要是为了获取权限*/
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    UserQueryFilter filter = new UserQueryFilter();
    filter.setName(name);
    User user = userService.queryUserByName(name); //queryUser中已经聚合了用户组等相关信息
    if (user == null) {
      return null;
    }
    //要把权限转成Collection<GrantedAuthority>的形式才能够给SpringSecurity直接使用
    // UserDetails.getAuthorities()
    return new MyUserDetails(user, user.getAuthorities());
  }
}
