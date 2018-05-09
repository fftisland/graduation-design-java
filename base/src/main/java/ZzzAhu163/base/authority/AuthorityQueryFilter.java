package ZzzAhu163.base.authority;

import ZzzAhu163.base.baseObject.BaseQueryFilter;
import lombok.Data;

/**
 * @author Zzz_Ahu_163
 * **/
@Data
public class AuthorityQueryFilter extends BaseQueryFilter {
    private AuthorityRole authorityRole;

    private DataType dataType;

    private int dataId;

    public AuthorityQueryFilter() {
        super();
    }

    public AuthorityQueryFilter(AuthorityRole authorityRole) {
        this.authorityRole = authorityRole;
    }

    public AuthorityQueryFilter(DataType dataType, int dataId) {
        super(dataId);
        this.dataType = dataType;
    }

    public void reset() {
        this.dataType = null;
        this.authorityRole = null;
    }
}
