package ZzzAhu163.base.ContactGroup.filter;

import ZzzAhu163.base.baseObject.BaseQueryFilter;
import lombok.Data;

/**
 * @author Zzz_Ahu_163
 * **/
@Data
public class ContactGroupQueryFilter extends BaseQueryFilter {
    public ContactGroupQueryFilter() {
        super();
    }

    public ContactGroupQueryFilter(int id) {
        super(id);
    }

    public void reset() {
        super.reset();
    }
}
