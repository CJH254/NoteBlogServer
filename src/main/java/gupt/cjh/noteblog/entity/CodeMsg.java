package gupt.cjh.noteblog.entity;

public enum CodeMsg {

    /**
     * 响应状态码
     * 成功响应统一200
     * 失败响应可细分
     */
    SUCCESS(200, "请求成功"),
    FAILED(201, "请求失败"),

    REGISTER_FAILED(40001,"注册失败"),
    USER_ERROR(40003,"用户不存在"),
    DATABASE_ERROR(40004,"数据库异常"),

    //Security错误码
    LOGIN_FAILED(301,"登录失败"),
    USERNAME_EXPIRED(302,"账户过期"),
    PASSWORD_EXPIRED(303,"密码过期"),
    LOCKED_EXPIRED(304,"账户被锁定"),
    DISABLED_EXP(305,"账户被禁用"),
    PASSWORD_EXP(306,"密码错误"),
    USERNAME_EXP(307,"用户名错误"),


    SESSION_REPEAT(40004,"用户重复登陆"),
    TOKEN_EXPIRED(400, "token已过期"),
    TOKEN_ERROR(401, "token错误"),
    REPEAT_BINDING(20003, "重复绑定"),
    UNIQUE_INDEX(20004, "重复数据"),
    POST_FAILED(40002, "发布失败"),
    UPDATE_FAILED(60002, "更新失败"),
    DELETE_FAILED(60004, "删除失败"),
    ;

    private int code;

    private String msg;

    private Integer type;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
