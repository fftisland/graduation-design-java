package ZzzAhu163.mapper.ContactGroup;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.ContactGroup.ContactGroup;
import ZzzAhu163.base.ContactGroup.ContactGroupQueryFilter;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface ContactGroupMapper extends BaseMapper {
    int insertContactGroup(ContactGroup contactGroup);
    int insertUserToList(ContactGroup contactGroup);
    int insertUserCcList(ContactGroup contactGroup);
    int insertUserBccList(ContactGroup contactGroup);

    int deleteContactGroupById(int id);

    int deleteAllContactGroupUser(int id);

    int queryContactGroupListCount(ContactGroupQueryFilter filter);

    List<ContactGroup> queryContactGroupList(ContactGroupQueryFilter filter);

    /**删除不在联系人组中的user**/
    int deleteNotInGroupMapToUser(ContactGroup contactGroup);
    int deleteNotInGroupMapCcUser(ContactGroup contactGroup);
    int deleteNotInGroupMapBccUser(ContactGroup contactGroup);

    int updateContactGroup(ContactGroup contactGroup);
}
