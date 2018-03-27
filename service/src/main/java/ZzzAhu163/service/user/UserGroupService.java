package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.base.user.filter.UserQueryFilter;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 **/
public interface UserGroupService {
  //insert
  boolean insertUserGroup(UserGroup userGroup);

  //delete
  boolean deleteUserGroupById(int id);

  //update
  boolean updateUserGroup(UserGroup userGroup);

  //query userGroup list count
  int queryUserGroupListCount(UserGroupQueryFilter filter);

  //query simple UserGroup List
  List<UserGroup> querySimpleUserGroupList(UserGroupQueryFilter filter);

  //query simple UserGroup List by IdList
  List<UserGroup> querySimpleUserGroupByIdList(List<Integer> idList);

  //query UserGroup IdList by UserId
  List<Integer> queryUserGroupIdListByUserId(int userId);

  //query simple UserGroup By UserID
  List<UserGroup> querySimpleUserGroupListByUserId(int userId);
}
