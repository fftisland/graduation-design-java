package ZzzAhu163.base.baseResult;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.ResultType;

import javax.validation.constraints.NotNull;

/**
 * @author Zzz_Ahu_163
 * 返回值类型
 **/

@Data
public class BaseResult {
    /*返回的消息*/
    private String msg;

    /*返回值状态码*/
    private ResultCode resultStatus;

    /*返回的数据*/
    private Object dataItems;

    //成功状态经常使用
    public static BaseResult getSuccessResult() {
        BaseResult result = new BaseResult();
        result.setResultStatus(ResultCode.SUCCESS);
        result.setMsg(ResultCode.SUCCESS.getName());
        return result;
    }

    //根据异常构造失败状态
    public static BaseResult getFailedResult(Exception e) {
        BaseResult result = new BaseResult();
        result.setResultStatus(ResultCode.FAILED);
        if (e == null || StringUtils.isBlank(e.toString())) {
            result.setMsg(ResultCode.FAILED.getName());
        } else {
            result.setMsg(e.toString());
        }
        return result;
    }
}
