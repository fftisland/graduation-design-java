package ZzzAhu163.mapper.user;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import ZzzAhu163.base.user.filter.UserQueryFilter;

import java.util.List;

/**
 *@author ZzzAhu163
 **/
public interface UserGroupMapper extends BaseMapper {
  //query list count
  int queryUserGroupListIdCount(UserGroupQueryFilter filter);

  //query list
  List<User> queryUserGroupIdList(UserQueryFilter filter);



  //insert
  int insertUserGroup(UserGroup userGroup);

  //delete
  int deleteUserGroup(int id);

  //update
  int updateUserGroup(UserGroup userGroup);
}