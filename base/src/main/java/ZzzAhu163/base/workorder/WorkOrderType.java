package ZzzAhu163.base.workorder;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Zzz_Ahu_163
 * **/

@AllArgsConstructor
@Getter
public enum WorkOrderType {
    BACK_END(1, "BACK_END", "服务端");

    private int code;
    private String name;
    private String description;
}
