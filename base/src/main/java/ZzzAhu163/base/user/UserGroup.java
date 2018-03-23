package ZzzAhu163.base.user;

import ZzzAhu163.base.baseObject.BaseObject;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 用户组
 **/
@Data
@Alias("UserGroup")
@ToString
public class UserGroup extends BaseObject{
  private UserGroupType userGroupType;

  private boolean buildIn;

  //用户组权限列表
  private List<AuthorityRole> authorities;

  public UserGroup(int id) {
    super(id);
  }

  public void reset() {
    this.userGroupType = UserGroupType.GROUP_USER;
    this.authorities = null;
    this.buildIn = false;
  }
}
