package ZzzAhu163.base.ContactGroup;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Zzz_Ahu_163
 * **/
@AllArgsConstructor
@Getter
public enum UserListType {
    TO_LIST(1, "接收人"),
    CC_LIST(2, "抄送人"),
    BCC_LIST(3, "密送人");

    private int code;
    private String description;
}
