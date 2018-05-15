package ZzzAhu163.base.user;

import ZzzAhu163.base.authority.AuthorityRole;
import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
public class User extends BaseObjectEx {

  private String email;

  private String password;

  private UserRole userRole;

  private int loginCount;

  private Timestamp lastLoginTime;

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
    this.userGroups = new ArrayList<>();
    this.authorities = new ArrayList<>();
  }

  public List<String> getAuthorityForLog() {
    if (CollectionUtils.isEmpty(getAuthorities())) {
      return null;
    }
    List<String> list = new ArrayList<>();
    for (GrantedAuthority grantedAuthority : authorities) {
      list.add(grantedAuthority.getAuthority());
    }
    return list;
  }

  public boolean hasAuthority(String name) {
    if (StringUtils.isBlank(name) || authorities == null) {
      return false;
    }
    AuthorityRole authorityRole = new AuthorityRole(name);
    for (GrantedAuthority grantedAuthority : authorities) {
      if (authorityRole.equals(grantedAuthority)) {
        return true;
      }
    }
    return false;
  }

  /**
   * 只要名字或者邮箱相同就认为是同一个user
   * **/
  public boolean equals(User user) {
    if (user == null) {
      return false;
    }
    if (StringUtils.isNotBlank(getName())) {
      if (getName().equals(user.getName())) {
        return true;
      }
    }
    if (StringUtils.isNotBlank(email)) {
      if (email.equals(user.getEmail())) {
        return true;
      }
    }
    return false;
  }
}
