package com.camel.dwsurvey.bpm.controller;

import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import javafx.concurrent.Task;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.DeploymentQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/flow")
public class SpringCloudBpmController {
    @Autowired
    private ProcessEngine engine;

    /**
     部署
     @return
     */
    @GetMapping("/deploy")
    public Result deploy(){
        DeploymentBuilder builder = engine.getRepositoryService().createDeployment();
        Deployment deployment = builder.addClasspathResource("processes/first.bpmn").deploy();
        return ResultUtil.success("部署完成" + deployment.getId(), deployment);
    }

    /**
     查询流程定义
     @param key
     @return
     */
    @GetMapping("/def/{key}")
    public Result definition(@PathVariable String key){
        List<ProcessDefinition> processDefinitions = engine.getRepositoryService().createProcessDefinitionQuery().processDefinitionKey(key).orderByProcessDefinitionVersion().desc().list();
        List result = new ArrayList();
        processDefinitions.forEach(processDefinition -> {
            Map map = new HashMap();
            map.put("id", processDefinition.getId());
            map.put("name", processDefinition.getName());
            map.put("description", processDefinition.getDescription());
            result.add(map);
        });
        return ResultUtil.success("查询成功", result);
    }

    /**
     根据流程定义ID 启动流程
     @param definitionId
     @return
     */
    @GetMapping("/start/{definitionId}")
    public Result start(@PathVariable String definitionId){
        ProcessInstance instance = engine.getRuntimeService().startProcessInstanceById(definitionId);
        return ResultUtil.success("启动完成", instance.getId());
    }

    @GetMapping("/task/{assignee}")
    public Result queryTask(@PathVariable String assignee){
        TaskQuery query = engine.getTaskService().createTaskQuery();
//        assignee = "张三";
//        query.taskAssignee(assignee);
        List list = new ArrayList();
        query.list().forEach(task -> {
            Map map = new HashMap();
            map.put("id", task.getId());
            map.put("assignee", task.getAssignee());
            map.put("name", task.getName());
            map.put("description", task.getDescription());
            list.add(map);
        });
        return ResultUtil.success("查询成功", list);
    }

    @GetMapping("/index")
    public String index(){
        return "bpm服务启动成功";
    }
}
