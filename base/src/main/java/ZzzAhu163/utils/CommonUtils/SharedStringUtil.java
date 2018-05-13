package ZzzAhu163.utils.CommonUtils;

import ZzzAhu163.base.authority.AuthorityRole;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    /**
     * pattern => current time string
     * **/
    public static String formatTime(String format) {
        if (StringUtils.isBlank(format)) {
            return null;
        }
        return new SimpleDateFormat(format).format(new Date());
    }
}
