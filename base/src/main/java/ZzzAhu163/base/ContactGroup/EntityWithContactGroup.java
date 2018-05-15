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
 * 具有联系人组的实体的父类
 * **/

@Data
@Alias("EntityWithContactGroup")
public class EntityWithContactGroup extends BaseObjectEx implements ContactUserOperation{
    /**联系人组**/
    private ContactGroup contactGroup;

    /**联系人组数据类型**/
    private ContactType contactType;

    public void reset() {
        super.reset();
        this.contactGroup = null;
    }

    public EntityWithContactGroup() {
        super();
    }

    public EntityWithContactGroup(ContactType contactType) {
        super();
        this.contactType = contactType;
    }

    @Override
    public void addUserToList(UserListType userListType, User user) {
        if (contactGroup == null) {
            if (contactType == null) {
                return;
            }
            contactGroup = new ContactGroup(contactType);
        }
        contactGroup.addUserToList(userListType, user);
    }

    @Override
    public boolean isUserListEmpty() {
        if (contactGroup == null) {
            return true;
        }
        return contactGroup.isUserListEmpty();
    }

    @Override
    public void cleanIllegalUser() {
        if (contactGroup != null) {
            contactGroup.cleanIllegalUser();
        }
    }

    @Override
    public JSONObject formatForLog() {
        if (contactGroup == null) {
            return null;
        }
        return contactGroup.formatForLog();
    }

    @Override
    public boolean isContainsUser(UserListType userListType, User user) {
        if (contactGroup == null) {
            return false;
        }
        return contactGroup.isContainsUser(userListType, user);
    }
}