package ZzzAhu163.mapper.user;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.user.UserGroup;
import ZzzAhu163.base.user.filter.UserGroupQueryFilter;
import java.util.List;

/**
 *@author ZzzAhu163
 **/
public interface UserGroupMapper extends BaseMapper {
  //query list count
  int queryUserGroupListCount(UserGroupQueryFilter filter);

  //query list
  List<UserGroup> querySimpleUserGroupList(UserGroupQueryFilter filter);

  //insert
  int insertUserGroup(UserGroup userGroup);

  //delete
  int deleteUserGroup(int id);

  //update
  int updateUserGroup(UserGroup userGroup);

  //query simple user group by idList
  List<UserGroup> querySimpleUserGroupListByIdList(List<Integer> idList);

  //query user group idList by user id
  List<Integer> queryUserGroupIdListByUserId(int userId);
}
