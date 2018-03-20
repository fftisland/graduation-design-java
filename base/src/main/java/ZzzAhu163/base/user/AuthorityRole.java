package ZzzAhu163.base.user;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;

import javax.lang.model.element.NestingKind;

/**
 * @author Zzz_Ahu_163
 * 扩展权限角色
 * **/
@Data
@Slf4j
@Alias("AuthorityRole")
public class AuthorityRole implements GrantedAuthority {
    private int id;
    private String description;
    private String authorityName;

    @Override
    public String getAuthority() {
        return authorityName;
    }

    public void reset() {
        id = -1;
        description = authorityName = null;
    }

    public AuthorityRole() {
        reset();
    }
}
