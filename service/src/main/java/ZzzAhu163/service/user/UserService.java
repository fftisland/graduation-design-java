package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.filter.UserQueryFilter;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 *@author Zzz_Ahu_163
 **/
public interface UserService {
    //query list count
    int queryUserListCount(UserQueryFilter filter);

    //query list
    List<User> querySimpleUserList(UserQueryFilter filter);

    //query user
    User queryUser(UserQueryFilter filter);

    //query all user info
    User queryUserAll(UserQueryFilter filter);

    //queryUserGroupIdListById
    List<Integer> queryUserGroupIdListById(int userId);

    //query User List 包含权限和用户组
    List<User> queryUserList(UserQueryFilter filter);
}
