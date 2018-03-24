package ZzzAhu163.mapper.user;
import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserQueryFilter;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface UserServiceMapper extends BaseMapper {
  //add
  int insertUser(User user);

  //delete
  int deleteUserById(int id);

  //update
  int updateUser(User user);

  //query count
  int queryUserListCount(UserQueryFilter filter);

  //query list
  List<User> queryUserList(UserQueryFilter filter);

  //query userGroup list count
  int queryUserGroupListCount(int id);

  //query userGroup List
  List<UserGroup> queryUserGroupList(int id);

  //query user group id list
  List<Integer> queryUserGroupIdListById(int userId);
}
