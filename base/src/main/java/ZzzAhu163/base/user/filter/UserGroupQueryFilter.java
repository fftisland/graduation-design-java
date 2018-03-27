package ZzzAhu163.base.user.filter;

import ZzzAhu163.base.baseObject.BaseQueryFilter;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

/**
 * @author ZzzAhu163
 * **/
@Data
public class UserGroupQueryFilter extends BaseQueryFilter {
  private UserGroup userGroup;

  public UserGroupQueryFilter() {
    super();
  }

  public UserGroupQueryFilter(int id) {
    super(id);
  }

  public UserGroupQueryFilter(@NonNull UserGroup userGroup) {
    super();
    setUserGroup(userGroup);
  }

  public void reset() {
    super.reset();
    this.userGroup = null;
  }

  public void setUserGroup(@NonNull UserGroup userGroup) {
    if (getId() == 0 && userGroup.getId() > 0) {
      setId(userGroup.getId());
    }
  }
}
