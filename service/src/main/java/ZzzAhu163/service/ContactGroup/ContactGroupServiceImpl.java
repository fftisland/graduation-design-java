package ZzzAhu163.service.ContactGroup;

import ZzzAhu163.base.ContactGroup.ContactGroup;
import ZzzAhu163.base.ContactGroup.ContactGroupQueryFilter;
import ZzzAhu163.mapper.ContactGroup.ContactGroupMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("contactGroupServiceImpl")
public class ContactGroupServiceImpl implements ContactGroupService {
    @Resource
    private ContactGroupMapper contactGroupMapper;

    @Override
    public boolean insertContactGroup(ContactGroup contactGroup) {
        if (contactGroup == null || contactGroup.getId() > 0) {
            return false;
        }
        contactGroupMapper.insertContactGroup(contactGroup);
        if (contactGroup.getId() <= 0) {
            return false;
        }
        insertUserToList(contactGroup);
        return true;
    }

    @Override
    public boolean deleteContactGroup(int id) {
        if (id <= 0) {
            return false;
        }
        int result = contactGroupMapper.deleteContactGroupById(id);
        if (result <= 0) {
            return false;
        }
        contactGroupMapper.deleteAllContactGroupUser(id);
        return true;
    }

    @Override
    public int queryContactGroupListCount(ContactGroupQueryFilter filter) {
        if (filter == null) {
            return 0;
        }
        return contactGroupMapper.queryContactGroupListCount(filter);
    }

    @Override
    public List<ContactGroup> queryContactGroupList(ContactGroupQueryFilter filter) {
        int count = queryContactGroupListCount(filter);
        if (count <= 0) {
            return null;
        }
        List<ContactGroup> list = contactGroupMapper.queryContactGroupList(filter);
        return CollectionUtils.isEmpty(list) ? null : list;
    }

    @Override
    public ContactGroup queryContactGroupById(int id) {
        if (id <= 0) {
            return null;
        }
        List<ContactGroup> list = queryContactGroupList(new ContactGroupQueryFilter(id));
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public boolean updateContactGroup(ContactGroup contactGroup) {
        if (contactGroup == null || contactGroup.getId() <= 0) {
            return false;
        }
        int result = contactGroupMapper.updateContactGroup(contactGroup);
        if (result <= 0) {
            return false;
        }
        insertUserToList(contactGroup);
        deleteNotInGroupMapUser(contactGroup);
        return true;
    }

    public void deleteNotInGroupMapUser(ContactGroup contactGroup) {
        if (contactGroup == null || contactGroup.getId() <= 0) {
            return;
        }
        contactGroupMapper.deleteNotInGroupMapToUser(contactGroup);
        contactGroupMapper.deleteNotInGroupMapCcUser(contactGroup);
        contactGroupMapper.deleteNotInGroupMapBccUser(contactGroup);
    }

    public void insertUserToList(ContactGroup contactGroup) {
        if (contactGroup == null || contactGroup.getId() <= 0 || contactGroup.isUserListEmpty()) {
            return;
        }
        contactGroup.cleanIllegalUser();
        //插入User
        if (CollectionUtils.isNotEmpty(contactGroup.getBaseContactObject().getToList())) {
            contactGroupMapper.insertUserToList(contactGroup);
        }
        if (CollectionUtils.isNotEmpty(contactGroup.getBaseContactObject().getCcList())) {
            contactGroupMapper.insertUserCcList(contactGroup);
        }
        if (CollectionUtils.isNotEmpty(contactGroup.getBaseContactObject().getBccList())) {
            contactGroupMapper.insertUserBccList(contactGroup);
        }
    }
}
