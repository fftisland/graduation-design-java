package ZzzAhu163.base.ContactGroup;

import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.user.User;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 联系人组在数据库中的实体
 * **/
@Alias("BaseContactObject")
@Data
public class BaseContactObject implements ContactUserOperation  {
    /**接收人**/
    private List<User> toList;

    /**抄送人**/
    private List<User> ccList;

    /**密送人**/
    private List<User> bccList;

    public BaseContactObject() {
        reset();
    }

    public void reset() {
        this.toList = new ArrayList<>();
        this.ccList = new ArrayList<>();
        this.bccList = new ArrayList<>();
    }

    public boolean isUserListEmpty() {
        if (CollectionUtils.isEmpty(toList) && CollectionUtils.isEmpty(ccList)
                && CollectionUtils.isEmpty(bccList)) {
            return true;
        }
        return false;
    }

    /**清除没有id的User**/
    public void cleanIllegalUser() {
        deleteIllegalUserFromList(toList);
        deleteIllegalUserFromList(ccList);
        deleteIllegalUserFromList(bccList);
    }

    @Override
    public JSONObject formatForLog() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("toList", getUserNameArray(toList));
        jsonObject.put("ccList", getUserNameArray(ccList));
        jsonObject.put("bccList", getUserNameArray(bccList));
        return jsonObject;
    }

    private JSONArray getUserNameArray(List<User> list) {
        JSONArray jsonArray = new JSONArray();
        if (CollectionUtils.isNotEmpty(list)) {
            for (User user : list) {
                jsonArray.add(user.getName());
            }
        }
        return jsonArray;
    }

    private void deleteIllegalUserFromList(List<User> list) {
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (user.getId() <= 0) {
                list.remove(i);
                i--;
            }
        }
    }

    public void addUserToList(UserListType userListType, User user) {
        if (userListType == null || user == null) {
            return;
        }
        if (isContainsUser(userListType, user)) {
            return;
        }
        if (UserListType.TO_LIST.equals(userListType)) {
            if (toList == null) {
                toList = new ArrayList<>();
            }
            toList.add(user);
        } else if (UserListType.CC_LIST.equals(userListType)) {
            if (ccList == null) {
                ccList = new ArrayList<>();
            }
            ccList.add(user);
        } else if (UserListType.BCC_LIST.equals(userListType)) {
            if (bccList == null) {
                bccList = new ArrayList<>();
            }
            bccList.add(user);
        }
    }

    public boolean isContainsUser(UserListType userListType, User user) {
        if (userListType == null || user == null) {
            return false;
        }
        if (UserListType.TO_LIST.equals(userListType)) {
            return userIsInList(user, toList);
        } else if (UserListType.CC_LIST.equals(userListType)) {
            return userIsInList(user, ccList);
        } else if (UserListType.BCC_LIST.equals(userListType)) {
            return userIsInList(user, bccList);
        }
        return false;
    }

    private boolean userIsInList(User user, List<User> list) {
        if (user == null || CollectionUtils.isEmpty(list)) {
            return false;
        }
        for (User temp : list) {
            if (temp.equals(user)) {
                return true;
            }
        }
        return false;
    }
}
