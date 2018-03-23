package ZzzAhu163.base.baseObject;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * @author ZzzAhu163
 * 扩展基本类
 * **/
@Data
@ToString
@Alias("BaseObjectEx")
public class BaseObjectEx extends BaseObject{
  private Timestamp createTime;

  private Timestamp updateTime;

  //作为备注使用，和description有些区别
  private String remark;

  public BaseObjectEx(int id) {
    super(id);
  }
}
