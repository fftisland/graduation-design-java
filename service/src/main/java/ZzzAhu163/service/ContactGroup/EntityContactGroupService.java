package ZzzAhu163.service.ContactGroup;

import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.ContactGroup.filter.EntityContactGroupQueryFilter;
import ZzzAhu163.base.ContactGroup.EntityType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EntityContactGroupService {

    boolean insertEntityContactGroup(EntityContactGroup entityWithContactGroup);

    boolean deleteEntityContactGroup(int entityId, EntityType entityType);

    boolean updateEntityContactGroup(EntityContactGroup entityContactGroup);

    int queryEntityContactGroupListCount(EntityContactGroupQueryFilter filter);

    List<EntityContactGroup> queryEntityContactGroupList(EntityContactGroupQueryFilter filter);
}
