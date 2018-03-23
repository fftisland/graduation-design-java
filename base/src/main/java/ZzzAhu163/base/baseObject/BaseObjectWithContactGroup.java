package ZzzAhu163.base.baseObject;

import ZzzAhu163.base.ContactGroup.ContactGroup;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 * @author ZzzAhu163
 * 带联系人组的基类
 **/
@Data
@Alias("BaseObjectWithContactGroup")
public class BaseObjectWithContactGroup extends BaseObjectEx{
  //某些情况下，可能不止一个联系人组，比如含有应急方案的情况下
  private List<ContactGroup> contactGroups;

  private EntityType entityType;

  public BaseObjectWithContactGroup(int id) {
    super(id);
  }

  public void reset() {
    this.entityType = EntityType.UNKNOWN;
    this.contactGroups = null;
  }
}
