package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 **/
public interface UserService {
  //query list count
  int queryUserListCount(UserQueryFilter filter);

  //query list
  List<User> querySimpleUserList(UserQueryFilter filter);

  //query User List 包含权限和用户组
  List<User> queryUserList(UserQueryFilter filter);

  //query user by Id
  User querySimpleUserById(int id);

  //query user by id 包含权限和用户组
  User queryUserById(int id);

  //query user by name
  User queryUserByName(String name);

  //query simple user by name
  User querySimpleUserByName(String name);

  //query simple user by email
  User querySimpleUserByEmail(String email);

  //insert user
  Boolean insertUser(User user);
}
