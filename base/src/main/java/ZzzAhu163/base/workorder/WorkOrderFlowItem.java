package ZzzAhu163.base.workorder;

import ZzzAhu163.base.ContactGroup.BaseContactObject;
import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author Zzz_Ahu_163
 * 记录工单流程中的每一个步骤
 * **/
@Alias("WorkOrderFlowItem")
@Data
public class WorkOrderFlowItem extends BaseContactObject {
    /**
     * 工单流程中的阶段
     * 支持管理员添加每种类型工单除了【基本过程】额外的处理阶段
     * 【基本过程】：创建 => 待审核 => [处理] => 完成 => 关闭
     * 其中[处理]过程就是可选，可以有 {0，n}轮处理过程
     * **/
    private int phase;

    /**
     * 这个阶段对应的工单的状态
     * **/
    private WorkOrderStatus workOrderStatus;

    public WorkOrderFlowItem() {
        reset();
    }

    public void reset() {
        super.reset();
        phase = 0;
        workOrderStatus = null;
    }
}
