package ZzzAhu163.base.ContactGroup;

import ZzzAhu163.base.baseObject.BaseContactObject;
import ZzzAhu163.base.baseObject.BaseObject;
import ZzzAhu163.base.baseObject.BaseObjectEx;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author ZzzAhu163
 * 联系人组
 * **/
@Alias("ContactGroup")
@Data
public class ContactGroup extends BaseObjectEx{
  private BaseContactObject baseContactObject;

  private NotifyType notifyType;

  //这个id就是map映射的id
  public ContactGroup(int id) {
    super(id);
  }

  public void reset() {
    this.baseContactObject = new BaseContactObject();
    this.notifyType = NotifyType.DEFAULT_NOTIFY;
  }
}
