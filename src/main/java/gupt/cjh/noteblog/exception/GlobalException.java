package gupt.cjh.noteblog.exception;


import gupt.cjh.noteblog.entity.CodeMsg;
import lombok.Data;

@Data
public class GlobalException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected int code;

    protected String msg;

    protected String message;

    public GlobalException() {
        super();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(CodeMsg enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public GlobalException(CodeMsg enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public GlobalException(String message, Throwable cause) {
        super(message, cause);
    }

}
