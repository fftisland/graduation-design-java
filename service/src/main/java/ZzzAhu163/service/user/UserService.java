package ZzzAhu163.service.user;

import ZzzAhu163.base.user.User;
import ZzzAhu163.base.user.filter.UserQueryFilter;

import java.util.List;

/**
 *@author Zzz_Ahu_163
 **/
public interface UserService {
    //query list count
    int queryUserListCount(UserQueryFilter filter);

    //query list
    List<User> queryUserList(UserQueryFilter filter);

    //query user
    User queryUser(UserQueryFilter filter);

    //query all user info
    User queryUserAll(UserQueryFilter filter);
}
