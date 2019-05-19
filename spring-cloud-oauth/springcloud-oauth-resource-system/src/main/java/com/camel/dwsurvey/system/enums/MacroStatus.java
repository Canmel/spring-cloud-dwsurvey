package com.camel.dwsurvey.system.enums;

import jdk.nashorn.internal.parser.JSONParser;

public enum MacroStatus implements BaseEnum {
    NORMAL("正常", 1), INVALID("无效", 0);
    private String description;
    private Integer code;
    private String column;

    public String getDescription() {
        return description;
    }

    public Integer getCode() {
        return code;
    }

    public String getColumn() {
        return column;
    }

    MacroStatus(String description, Integer code) {
        this.description = description;
        this.code = code;
        this.column = "status";
    }

    @Override
    public Integer getValue() {
        return getCode();
    }

    @Override
    public String toString() {
        return "MacroStatus{" +
                "description='" + description + '\'' +
                ", code=" + code +
                ", column='" + column + '\'' +
                '}';
    }
}