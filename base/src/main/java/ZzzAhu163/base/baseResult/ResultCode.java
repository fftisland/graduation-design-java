package ZzzAhu163.base.baseResult;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Zzz_Ahu_163
 * 返回值状态码
 * **/
@AllArgsConstructor
@Getter
public enum ResultCode {

    SUCCESS(0, "SUCCESS", "表示请求成功"),
    FAILED(1, "FAILED", "表示请求失败");

    private int code;
    private String name;
    private String description;
}
