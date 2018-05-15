package ZzzAhu163.base.ContactGroup;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.user.User;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 联系人组
 * **/
@Alias("ContactGroup")
@Data
public class ContactGroup extends BaseObjectEx implements ContactUserOperation{

    /**
     * 联系人组的类型
     * **/
    private ContactType contactType;

    /**
     * 联系人组实体
     * **/
    private BaseContactObject baseContactObject;

    public ContactGroup() {
        super();
    }

    public ContactGroup(ContactType contactType) {
        super();
        this.contactType = contactType;
    }

    public void reset() {
        super.reset();
        this.contactType = ContactType.WITHOUT_TYPE;
        this.baseContactObject = new BaseContactObject();
    }

    public void addUserToList(UserListType userListType, User user) {
        if (baseContactObject == null) {
            baseContactObject = new BaseContactObject();
        }
        baseContactObject.addUserToList(userListType, user);
    }

    @Override
    public boolean isUserListEmpty() {
        if (baseContactObject == null) {
            return true;
        }
        return baseContactObject.isUserListEmpty();
    }

    @Override
    public void cleanIllegalUser() {
        if (baseContactObject != null) {
            baseContactObject.cleanIllegalUser();
        }
    }

    @Override
    public JSONObject formatForLog() {
        if (baseContactObject == null) {
            return null;
        }
        return baseContactObject.formatForLog();
    }

    public boolean isContainsUser(UserListType userListType, User user) {
        if (baseContactObject == null) {
            return false;
        }
        return baseContactObject.isContainsUser(userListType, user);
    }
}
