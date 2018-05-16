package ZzzAhu163.service.ContactGroup;

import ZzzAhu163.base.ContactGroup.ContactGroup;
import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.ContactGroup.filter.EntityContactGroupQueryFilter;
import ZzzAhu163.base.ContactGroup.EntityType;
import ZzzAhu163.mapper.ContactGroup.EntityContactGroupMapper;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service("entityContactGroupService")
public class EntityContactGroupServiceImpl implements EntityContactGroupService {
    @Resource
    private EntityContactGroupMapper entityContactGroupMapper;
    @Resource
    private ContactGroupService contactGroupService;

    @Override
    public boolean insertEntityContactGroup(EntityContactGroup entityWithContactGroup) {
        if (entityWithContactGroup.isEmpty()) {
            return false;
        }
        if (entityWithContactGroup.getContactGroup().getId() <= 0) {
            contactGroupService.insertContactGroup(entityWithContactGroup.getContactGroup());
        }
        entityContactGroupMapper.insertEntityContactGroup(entityWithContactGroup);
        return true;
    }

    @Override
    public boolean deleteEntityContactGroup(int entityId, EntityType entityType) {
        if (entityId <= 0 || entityType == null) {
            return false;
        }
        List<EntityContactGroup> list =
                queryEntityContactGroupList(new EntityContactGroupQueryFilter(entityId, entityType));
        if (CollectionUtils.isEmpty(list)) {
            return true;
        }
        for (EntityContactGroup entityContactGroup : list) {
            entityContactGroupMapper.deleteEntityContactGroup(entityId, entityType);
            if (!entityContactGroup.isUserListEmpty()) {
                contactGroupService.deleteContactGroup(entityContactGroup.getContactGroup().getId());
            }
        }
        return true;
    }

    @Override
    public boolean updateEntityContactGroup(EntityContactGroup entityContactGroup) {
        if (entityContactGroup == null || entityContactGroup.getId() <= 0
                || entityContactGroup.getEntityType() == null) {
            return false;
        }
        if (!contactGroupService.updateContactGroup(entityContactGroup.getContactGroup())) {
           return false;
        }
        entityContactGroupMapper.updateEntityContactGroup(entityContactGroup);
        return true;
    }

    @Override
    public int queryEntityContactGroupListCount(EntityContactGroupQueryFilter filter) {
        if (filter == null) {
            return 0;
        }
        return entityContactGroupMapper.queryEntityContactGroupListCount(filter);
    }

    @Override
    public List<EntityContactGroup> queryEntityContactGroupList(EntityContactGroupQueryFilter filter) {
        int count = queryEntityContactGroupListCount(filter);
        if (count <= 0) {
            return null;
        }
        List<EntityContactGroup> list = entityContactGroupMapper.queryEntityContactGroupList(filter);
        //TODO:填充联系人组
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        for (EntityContactGroup entityContactGroup : list) {
            ContactGroup contactGroup = contactGroupService.queryContactGroupById(entityContactGroup.getContactGroup().getId());
            entityContactGroup.setContactGroup(contactGroup);
        }
        return list;
    }
}
