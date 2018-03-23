package ZzzAhu163.base.baseObject;

import lombok.*;
import org.apache.ibatis.type.Alias;

/**
 * @author ZzzAhu163
 * 整个项目的基础类
 **/

@Data
@Alias("BaseObject")
@ToString
public class BaseObject {
  private int id;
  private String name;
  private String description;

  public BaseObject(){reset();}
  /**通常来说一般只需要id的构造函数**/
  public BaseObject(int id) {
    reset();
    this.id = id;
  }

  public void reset() {
    this.id = 0;
    this.name = null;
    this.description = null;
  }
}
