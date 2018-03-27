package ZzzAhu163.base.user;

import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.baseObject.IsBuildIn;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@AllArgsConstructor
@Builder
public class UserGroup extends BaseObjectEx{
  private UserGroupType userGroupType;

  //1表示内置 0表示添加 null表示忽略
  private IsBuildIn isBuildIn;

  //用户组权限列表
  private List<AuthorityRole> authorities;

  public UserGroup(){}

  public UserGroup(int id) {
    super(id);
  }

  public void reset() {
    super.reset();
    this.userGroupType = null;
    this.authorities = null;
    this.isBuildIn = null;
  }
}
