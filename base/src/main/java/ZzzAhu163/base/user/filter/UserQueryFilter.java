package ZzzAhu163.base.user.filter;

import ZzzAhu163.base.baseObject.BaseQueryFilter;
import ZzzAhu163.base.user.User;
import lombok.Data;
import lombok.NonNull;
import org.apache.ibatis.type.Alias;

/**
 * @author ZzzAhu163
 **/
@Data
public class UserQueryFilter extends BaseQueryFilter {
  private User user;

  public UserQueryFilter() {
    super();
  }

  public UserQueryFilter(int id) {
    super(id);
  }

  public UserQueryFilter(User user) {
    super();
    setUser(user);
  }

  public void reset() {
    user = null;
  }

  //如果有相同属性，尽量以filter中的为准
  public void setUser(@NonNull User user) {
    if (getId() == 0 && user.getId() > 0) {
      setId(user.getId());
    }
  }

  public void setId(int id) {
    super.setId(id);
    user.setId(id);
  }
}
