package ZzzAhu163.service.security;

import ZzzAhu163.base.user.MyUserDetails;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserRole;
import ZzzAhu163.service.user.UserService;
import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Data
@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    //这个UserService需要在xml中使用硬编码的形式进行注入
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据username 从数据库中取出MyUserDetails;
        User user = new User();
        user.setUserName("ZzzAhu163");
        user.setPassword("ZzzAhu163");
        user.setUserRole(UserRole.ROLE_NORMAL);
        return null;
    }
}
