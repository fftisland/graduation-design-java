package ZzzAhu163.base.workorder;

import ZzzAhu163.base.ContactGroup.EntityContactGroup;
import ZzzAhu163.base.user.User;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * 工单申请提交Article
 * **/
@Data
@Alias("WorkOrder")
public class WorkOrder extends EntityContactGroup{

    private int articleId;

    private User applyUser;


}
