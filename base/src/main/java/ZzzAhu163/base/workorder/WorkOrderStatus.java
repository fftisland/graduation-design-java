package ZzzAhu163.base.workorder;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Zzz_Ahu_163
 * 工单状态
 * **/
@Getter
@AllArgsConstructor
public enum WorkOrderStatus {
    CREATE(1, "CREATE", "创建状态");

    private int code;
    private String name;
    private String description;

    public static WorkOrderStatus getStatusByCode(int code) {
        if (code <= 0) {
            return null;
        }
        for (WorkOrderStatus status : WorkOrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        return null;
    }
}
