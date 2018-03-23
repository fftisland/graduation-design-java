package ZzzAhu163.base.user;


import ZzzAhu163.base.baseObject.BaseObject;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 **/

@Alias("User")
@Data
public class User extends BaseObject{

    private String email;

    private String password;

    private UserRole userRole;

    private int loginCount;

    private Timestamp lastLoginTime;

    private Timestamp createTime;

    private Timestamp updateTime;

    private List<UserGroup> userGroups;

    //用户权限角色，由我们自己使用
    private List<AuthorityRole> authorityRoles;

    //单纯的用户权限，是提供给Security框架使用的
    private List<GrantedAuthority> authorities;

    public User() {
      super();
    }

    public User(int id) {
      super(id);
    }

    public void  reset() {
      this.email = null;
      this.password = null;
      this.userRole = UserRole.UNKNOWN;
      this.loginCount = 0;
      this.lastLoginTime = null;
      this.createTime = null;
      this.updateTime = null;
      this.userGroups = new ArrayList<>();
      this.authorities = new ArrayList<>();
    }
}
