package ZzzAhu163.base.baseObject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * @author ZzzAhu163
 * 扩展基本类
 * **/
@Data
@ToString(callSuper = true)
@Alias("BaseObjectEx")
@EqualsAndHashCode(callSuper = true)
public class BaseObjectEx extends BaseObject{
  private Timestamp createTime;

  private Timestamp updateTime;

  //作为备注使用，和description有些区别
  private String remark;

  public BaseObjectEx(int id) {
    super(id);
  }

  public BaseObjectEx(){
    super();
  }

  public void reset() {
    super.reset();
    this.createTime = null;
    this.updateTime = null;
    this.remark = null;
  }
}
