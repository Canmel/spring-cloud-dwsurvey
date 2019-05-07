package com.camel.dwsurvey.system.enums;

import org.springframework.util.CollectionUtils;

import java.util.*;

public enum MenuType {
    TOP(0, "一级菜单"), SUB(1, "二级菜单");

    private Integer code;

    private String description;

    private String column;

    MenuType(Integer code, String description) {
        this.code = code;
        this.description = description;
        this.column = "type";
    }

    MenuType() {
    }

    public String getColumn() {
        return column;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Map getValueMap() {
        Map map = new HashMap();
        map.put("name", this.getDescription());
        map.put("value", this.getCode());
        return map;
    }

    public static List all(){
        List list = new ArrayList<>();
        for (MenuType type: MenuType.values()) {
            list.add(type.getValueMap());
        }
        return list;
    }
}
