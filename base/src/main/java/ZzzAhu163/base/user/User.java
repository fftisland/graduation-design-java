package ZzzAhu163.base.user;

import ZzzAhu163.base.baseObject.BaseObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * @author ZzzAhu163
 **/

@Alias("User")
@Data
@Slf4j
@Builder()
@AllArgsConstructor
@ToString(callSuper = true)
public class User extends BaseObject {

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

  public void reset() {
    this.email = null;
    this.password = null;
    this.userRole = null;
    this.loginCount = 0;
    this.lastLoginTime = null;
    this.createTime = null;
    this.updateTime = null;
    this.userGroups = new ArrayList<>();
    this.authorities = new ArrayList<>();
  }
}
