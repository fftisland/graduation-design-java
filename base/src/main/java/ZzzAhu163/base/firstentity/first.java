package ZzzAhu163.base.firstentity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("first")
public class first {
  private String data;

  private int id;
}
