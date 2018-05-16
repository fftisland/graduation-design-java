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
@Alias("EntityContactGroup")
public class EntityContactGroup extends BaseObjectEx implements ContactUserOperation{
    /**联系人组**/
    private ContactGroup contactGroup;

    /**类型**/
    private EntityType entityType;

    public void reset() {
        super.reset();
        contactGroup = new ContactGroup();
        entityType = null;
    }

    public EntityContactGroup() {
        super();
    }

    public boolean isEmpty() {
        if (entityType == null || getId() <=  0 || isUserListEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public void addUserToList(UserListType userListType, User user) {
        if (contactGroup == null) {
            contactGroup = new ContactGroup();
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
