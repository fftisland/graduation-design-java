package ZzzAhu163.base.user;


import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 **/

@Alias("User")
@Data
public class User {
    private int id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;

    private int loginCount;

    private Timestamp lastLoginTime;

    private Timestamp createTime;

    private Timestamp updateTime;

    private List<UserGroup> userGroups;

    private List<AuthorityRole> authorityRoles;

    public boolean hasAuthority(String role) {
        return true;
    }
}
