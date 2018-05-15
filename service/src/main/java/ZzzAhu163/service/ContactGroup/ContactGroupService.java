package ZzzAhu163.service.ContactGroup;

import ZzzAhu163.base.ContactGroup.ContactGroup;
import ZzzAhu163.base.ContactGroup.ContactGroupQueryFilter;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface ContactGroupService {
    boolean insertContactGroup(ContactGroup contactGroup);

    boolean deleteContactGroup(int id);

    int queryContactGroupListCount(ContactGroupQueryFilter filter);

    List<ContactGroup> queryContactGroupList(ContactGroupQueryFilter filter);

    ContactGroup queryContactGroupById(int id);

    boolean updateContactGroup(ContactGroup contactGroup);
}
