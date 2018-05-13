package ZzzAhu163.utils.CommonUtils;

import ZzzAhu163.base.authority.AuthorityRole;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public static String formatTime(String format, Date date) {
        if (StringUtils.isBlank(format)) {
            return null;
        }
        if (date != null) {
            return new SimpleDateFormat(format).format(date);
        }
        return new SimpleDateFormat(format).format(new Date());
    }

    /**
     * random string by uuid and timestamp
     * **/
    public static String getRandomString() {
        StringBuilder builder = new StringBuilder();
        String prefix = formatTime("yyyyMMdd_HHmmss", null);
        String postfix = UUID.randomUUID().toString().substring(0, 8);
        builder.append(prefix).append("_").append(postfix);
        return builder.toString();
    }
}
