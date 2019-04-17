package com.camel.core.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    UNAUTHORIZED(401, "访问的服务需要身份认证"),
    SESSION_INVALID(401, "session失效"),
    CREDENTIALS_EXPIRED(40001, "您的密码已过期,请修改密码!"),
    CREDENTIALS_TOO_WEAK(40002, "您的密码强度太弱,请修改密码!"),
    NOT_VALID_PARAM(40005, "参数不合法"),
    SUCCESS(200, "操作成功");

    private Integer code;
    private String msg;

    private ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
