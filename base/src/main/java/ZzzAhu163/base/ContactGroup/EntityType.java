package ZzzAhu163.base.ContactGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.swing.text.html.parser.Entity;

/**
 * @author Zzz_Ahu_163
 * EntityType
 * **/
@Getter
@AllArgsConstructor
public enum EntityType {
    WORK_ORDER(1, "WORK_ORDER", "工单"),
    WORK_ORDER_FLOW(2, "WORK_ORDER_FLOW", "工单流程"),
    WORK_ORDER_FLOW_ITEM(3, "WORK_ORDER_FLOW_ITEM", "工单流程步骤");

    private int code;
    private String name;
    private String description;

    public static EntityType getEntityTypeByCode(int code) {
        if (code <= 0) {
            return null;
        }
        for (EntityType entity : EntityType.values()) {
            if (entity.getCode() == code) {
                return entity;
            }
        }
        return null;
    }
}
