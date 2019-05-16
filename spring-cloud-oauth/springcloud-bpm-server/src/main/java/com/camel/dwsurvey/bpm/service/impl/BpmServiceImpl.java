package com.camel.dwsurvey.bpm.service.impl;

import com.camel.dwsurvey.bpm.service.BpmService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BpmServiceImpl implements BpmService {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Override
    public Deployment deploy(String path) {
        DeploymentBuilder builder = repositoryService.createDeployment();
        Deployment deployment = builder.addClasspathResource(path).deploy();
        return deployment;
    }

    @Override
    public Deployment deploy(String resourceName, String text) {
        return null;
    }

    @Override
    public List definition(String key) {
        List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey(key).orderByProcessDefinitionVersion().desc().list();
        List result = new ArrayList();
        processDefinitions.forEach(processDefinition -> {
            Map map = new HashMap();
            map.put("id", processDefinition.getId());
            map.put("name", processDefinition.getName());
            map.put("description", processDefinition.getDescription());
            result.add(map);
        });
        return result;
    }

    @Override
    public List queryTask(String key) {
        TaskQuery query = taskService.createTaskQuery();
        query.active().taskAssignee(key);
        List list = new ArrayList();
        query.list().forEach(task -> {
            Map map = new HashMap();
            map.put("id", task.getId());
            map.put("assignee", task.getAssignee());
            map.put("name", task.getName());
            map.put("description", task.getDescription());
            list.add(map);
        });
        return list;
    }

    @Override
    public List queryTaskByGroupId(List<String> groupId) {
        TaskQuery query = taskService.createTaskQuery();
        List<Task> tasks = query.taskCandidateGroupIn(groupId).list();
        return tasks;
    }
}
