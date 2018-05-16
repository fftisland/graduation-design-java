package ZzzAhu163.base.ContactGroup;

import ZzzAhu163.base.user.User;
import com.alibaba.fastjson.JSONObject;

/**
 * @author Zzz_Ahu_163
 * 联系人组中关于User的操作:
 * EntityContactGroup => ContactGroup => BaseContactObject
 * **/
public interface ContactUserOperation {
    void addUserToList(UserListType userListType, User user);

    boolean isContainsUser(UserListType userListType, User user);

    boolean isUserListEmpty();

    void cleanIllegalUser();

    JSONObject formatForLog();
}
