package ZzzAhu163.base.user;

import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;

import javax.lang.model.element.NestingKind;
import java.sql.Timestamp;

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

    @Override
    public String getAuthority() {
        return getName();
    }

    public void reset() {
      super.reset();
    }
}
