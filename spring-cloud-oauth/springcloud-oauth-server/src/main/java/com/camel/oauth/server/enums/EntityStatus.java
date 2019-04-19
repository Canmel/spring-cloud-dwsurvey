package com.camel.oauth.server.enums;

import lombok.Data;

public enum EntityStatus {
    UNAVAILABLE("0", "不可用"),ENABLE("1", "可用");

    private String code;
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
