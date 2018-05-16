package ZzzAhu163.mapper.ContactGroup;

import ZzzAhu163.BaseMapper;
import ZzzAhu163.base.ContactGroup.filter.EntityContactGroupQueryFilter;
import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.ContactGroup.EntityType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * **/
public interface EntityContactGroupMapper extends BaseMapper{
    int insertEntityContactGroup(EntityContactGroup entityWithContactGroup);

    int deleteEntityContactGroup(@Param("entityId")int entityId, @Param("entityType") EntityType entityType);

    int updateEntityContactGroup(EntityContactGroup entityContactGroup);

    int queryEntityContactGroupListCount(EntityContactGroupQueryFilter filter);

    List<EntityContactGroup> queryEntityContactGroupList(EntityContactGroupQueryFilter filter);
}
