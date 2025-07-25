package admin.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult {

    /**
     * 状态码 20000 表示成功
     */
    private Integer code;

    /**
     * 数据
     */
    private Object data;

    /**
     * 描述
     */
    private String msg;


    /**
     *  获取远程调用数据
     *  注意事项：支持多单词下划线转驼峰（序列化和反序列化）
     *
     * @param typeReference
     * @param <T>
     * @return
     */
    public <T> T getData(TypeReference<T> typeReference){
        return JSON.parseObject(JSON.toJSONString(data),typeReference);
    }

    /**
     * 成功，不传入数据
     * @return
     */
    public static BaseResult buildSuccess() {
        return new BaseResult(20000, null, null);
    }

    /**
     *  成功，传入数据
     * @param data
     * @return
     */
    public static BaseResult buildSuccess(Object data) {
        return new BaseResult(20000, data, "success");
    }

    /**
     * 失败，传入描述信息
     * @param msg
     * @return
     */
    public static BaseResult buildError(String msg) {
        return new BaseResult(-1, null, msg);
    }

    public static BaseResult buildError() {
        return new BaseResult(-1, null, "");
    }


    /**
     * 自定义状态码和错误信息
     * @param code
     * @param msg
     * @return
     */
    public static BaseResult buildCodeAndMsg(int code, String msg) {
        return new BaseResult(code, null, msg);
    }

}
