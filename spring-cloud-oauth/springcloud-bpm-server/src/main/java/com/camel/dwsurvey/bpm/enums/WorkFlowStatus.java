package com.camel.dwsurvey.bpm.enums;

import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  前端控制器
 *
 * @author baily
 * 描述:
 * ${DESCRIPTION}
 *   ┏ ┓   ┏ ┓
 *  ┏┛ ┻━━━┛ ┻┓
 *  ┃         ┃
 *  ┃    ━    ┃
 *  ┃  ┳┛  ┗┳ ┃
 *  ┃         ┃
 *  ┃    ┻    ┃
 *  ┃         ┃
 *  ┗━━┓    ┏━┛
 *     ┃    ┃神兽保佑
 *     ┃    ┃代码无BUG！
 *     ┃    ┗━━━━━━━┓
 *     ┃            ┣┓
 *     ┃            ┏┛
 *     ┗┓┓┏━━━━━━┳┓┏┛
 *      ┃┫┫      ┃┫┫
 *      ┗┻┛      ┗┻┛
 * @since 2018年08月17日
 */
public enum WorkFlowStatus {
    CREATED("创建", 1),
    DEPLOYED("发布", 2);

    private String name;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    WorkFlowStatus(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Map getValueMap() {
        Map map = new HashMap();
        map.put("name", this.getName());
        map.put("value", this.getValue());
        return map;
    }

    public static List all() {
        List list = new ArrayList<>();
        for (WorkFlowStatus flowType : WorkFlowStatus.values()) {
            list.add(flowType.getValueMap());
        }
        return list;
    }

    public static WorkFlowStatus valueToEm(Integer value){
        if(ObjectUtils.isEmpty(value)){
            return null;
        }
        for (WorkFlowStatus flowType : WorkFlowStatus.values()) {
            if(flowType.getValue().equals(value)){
                return flowType;
            }
        }
        return null;
    }
}
