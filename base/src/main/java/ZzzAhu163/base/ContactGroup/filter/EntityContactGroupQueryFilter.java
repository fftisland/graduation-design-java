package ZzzAhu163.base.ContactGroup.filter;

import ZzzAhu163.base.ContactGroup.EntityType;
import ZzzAhu163.base.baseObject.BaseQueryFilter;
import lombok.Data;

/**
 * @author Zzz_Ahu_163
 * **/
@Data
public class EntityContactGroupQueryFilter extends BaseQueryFilter {

    private EntityType entityType;

    public EntityContactGroupQueryFilter() {
        super();
    }

    public EntityContactGroupQueryFilter(int id, EntityType entityType) {
        super(id);
        this.entityType = entityType;
    }

    public void reset() {
        super.reset();
        entityType = null;
    }
}
