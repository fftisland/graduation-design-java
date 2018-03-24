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

    //query UserGroup List
    List<UserGroup> queryUserGroupList(UserGroupQueryFilter filter);

    //query simple UserGroup
    UserGroup querySimpleUserGroup(UserGroupQueryFilter filter);
}
