package com.camel.dwsurvey.bpm.utils;

import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;

import java.util.HashMap;
import java.util.Map;

public class ActivitiObj2HashMapUtils {
    private final static ActivitiObj2HashMapUtils INSTANCE = new ActivitiObj2HashMapUtils();

    public ActivitiObj2HashMapUtils() {
    }

    public static ActivitiObj2HashMapUtils getInstance(){return INSTANCE;}

    public Map<String, Object> processDefinition2Map(ProcessDefinition definition){
        Map<String, Object> result = new HashMap<>();
        result.put("key", definition.getKey());
        result.put("version", definition.getVersion());
        result.put("deploymentId", definition.getDeploymentId());
        result.put("resourceName", definition.getResourceName());
        result.put("diagramResourceName", definition.getDiagramResourceName());
        result.put("id", definition.getId());
        result.put("description", definition.getDescription());
        return result;
    }
 }
