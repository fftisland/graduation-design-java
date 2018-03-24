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
    //这个UserService需要在xml中使用硬编码的形式进行注入
    private UserService userService;

    /*自定义loadUserByUsername方法，根据用户名获取UserDetails，主要是为了获取权限*/
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        UserQueryFilter filter = new UserQueryFilter();
        filter.setName(name);
        User user = userService.queryUser(filter);
        if (user == null) {
            return null;
        }
        //填充User的

        //要把权限转成Collection<GrantedAuthority>的形式才能够给SpringSecurity直接使用
        // UserDetails.getAuthorities()
        return new MyUserDetails(user, getAuthorities(user));
    }

  /**获取权限，根据角色和用户组，决定用户具有什么权限**/
  private Collection<GrantedAuthority> getAuthorities(User user) {
    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    //TODO：根据user，结合Role和group，获取用户拥有的权限信息，这里目前先直接指定一个ROLE_ADMIN
    //1、查询User的所有Group
    //2、根据User的Role进行聚合
    //3、拆分成两种权限，赋值给User
    return grantedAuthorities;
  }
}
