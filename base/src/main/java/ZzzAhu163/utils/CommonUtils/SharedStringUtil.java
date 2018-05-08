package ZzzAhu163.utils.CommonUtils;

import ZzzAhu163.base.user.AuthorityRole;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 处理字符串之类的工具类
 * **/
public class SharedStringUtil {
    /*
    * String [] => List<AuthorityRole>
    * */
    public static List<AuthorityRole> convertToAuthorityRole(String ... authorityName) {
        List<AuthorityRole> list = new ArrayList<>();
        //foreach循环
        for (String name : authorityName) {
            AuthorityRole role = new AuthorityRole();
            role.setName(name);
            list.add(role);
        }
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list;
    }
}
