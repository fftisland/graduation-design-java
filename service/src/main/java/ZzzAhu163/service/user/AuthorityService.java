package ZzzAhu163.service.user;

import ZzzAhu163.base.user.AuthorityRole;

import java.util.List;

/**
 * @author ZzzAhu163
 **/
public interface AuthorityService {
  //query Authority by group id
  List<AuthorityRole> queryAuthorityListByUserGroupId(int userGroupId);
}
