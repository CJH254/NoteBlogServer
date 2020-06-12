package gupt.cjh.noteblog.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @ClassName RespBean
 * @Description: TODO
 * @Author 二维世界是个圆
 * @Date 2020/2/26
 * @Version V1.0
 **/
@Data
@ToString
@NoArgsConstructor
public class RespBean<T> implements Serializable {
    private Integer status;
    private String msg;
    private T data;

    private RespBean(String msg) {
        this.msg = msg;
    }

    public RespBean(CodeMsg codeMsg) {
        this.status = codeMsg.getCode();
        this.msg = codeMsg.getMsg();
    }

    private RespBean(CodeMsg codeMsg, T data) {
        if (codeMsg != null) {
            this.status = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
        if (data != null) {
            this.data = data;
        }
    }

    private RespBean(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 成功调用
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespBean<T> ok(String msg) {
        return new RespBean<T>(msg);
    }

    public static <T> RespBean<T> ok(Integer status, String msg) {
        return new RespBean<T>(status, msg);
    }

    public static <T> RespBean<T> ok(CodeMsg codeMsg) {
        return new RespBean<T>(codeMsg);
    }

    public static <T> RespBean<T> ok(CodeMsg codeMsg, T data) {
        return new RespBean<>(codeMsg, data);
    }

    /**
     * 失败调用
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> RespBean<T> error(String msg) {
        return new RespBean<T>(msg);
    }

    public static <T> RespBean<T> error(Integer status, String msg) {
        return new RespBean<T>(status, msg);
    }

    public static <T> RespBean<T> error(CodeMsg codeMsg) {
        return new RespBean<T>(codeMsg);
    }

    public static <T> RespBean<T> error(CodeMsg codeMsg, T data) {
        return new RespBean<>(codeMsg, data);
    }


}
