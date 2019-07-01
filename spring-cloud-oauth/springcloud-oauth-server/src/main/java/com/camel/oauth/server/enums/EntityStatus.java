package com.camel.oauth.server.enums;

/** @author baily */
public enum EntityStatus {
    /**/
    UNAVAILABLE("0", "不可用"), ENABLE("1", "可用");

    /**
     数据代码
     */
    private String code;
    /**
     备注
     */
    private String description;

    EntityStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
