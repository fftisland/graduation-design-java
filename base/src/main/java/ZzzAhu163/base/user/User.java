package ZzzAhu163.base.user;

import ZzzAhu163.base.baseObject.BaseObject;
import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;
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

    //个人权限
    private List<AuthorityRole> authorityRoles;

    //merge 个人权限+组权限
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

    public void mergeAuthorities() throws Exception {
        if (CollectionUtils.isEmpty(userGroups)) {
            throw new Exception("user has not join any group");
        }
        if (userRole.equals(UserRole.UNKNOWN)) {
            //1、未知身份，没有权限
            userGroups = null;
        } else if (userRole.equals(UserRole.ROLE_NORMAL)) {
            //2、普通用户，只有组权限

        } else if (userRole.equals(UserRole.ROLE_ADMIN)) {
            //3、管理员，既有组权限，又有个人权限
        }
    }
}
