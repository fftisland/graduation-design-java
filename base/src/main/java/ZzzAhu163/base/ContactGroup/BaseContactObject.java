package ZzzAhu163.base.ContactGroup;

import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import ZzzAhu163.base.user.User;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author Zzz_Ahu_163
 * 联系人组在数据库中的实体
 * **/
@Alias("BaseContactObject")
@Data
public class BaseContactObject extends BaseObject{
    public BaseContactObject() {
        super();
    }

    public BaseContactObject(String name) {
        super();
        setName(name);
    }

    /**接收人**/
    private List<User> toList;

    /**抄送人**/
    private List<User> ccList;

    /**密送人**/
    private List<User> bccList;


    public void reset() {
        super.reset();
        this.toList = null;
        this.ccList = null;
        this.bccList = null;
    }
}
