package ZzzAhu163.base.baseObject;

import ZzzAhu163.base.user.User;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.List;

/**
 *
 * 联系人组的基本类
 **/
@Data
@Alias("BaseContactObject")
public class BaseContactObject {
  private BaseObject data;

  //联系人
  private List<User> ToList;

  //抄送人
  private List<User> CcList;

  //密送人
  private List<User> BcList;
}
