package ZzzAhu163.base.authority;

import ZzzAhu163.base.baseObject.BaseObjectEx;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Zzz_Ahu_163
 * 扩展权限角色
 * **/
@Data
@Slf4j
@Alias("AuthorityRole")
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AuthorityRole  extends BaseObjectEx implements GrantedAuthority{
    public AuthorityRole() {
      super();
    }

    public AuthorityRole(String name) {
        super();
        setName(name);
    }

    @Override
    public String getAuthority() {
        return getName();
    }

    public void reset() {
      super.reset();
    }

    public boolean equals(GrantedAuthority authority) {
        if (authority == null
                || StringUtils.isBlank(authority.getAuthority()) || StringUtils.isBlank(getAuthority())) {
            return false;
        }
        return authority.getAuthority().equals(getAuthority());
    }
}
