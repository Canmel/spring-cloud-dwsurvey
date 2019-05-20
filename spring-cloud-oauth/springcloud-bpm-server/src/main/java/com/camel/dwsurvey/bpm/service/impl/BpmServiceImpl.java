package com.camel.dwsurvey.bpm.service.impl;

import com.camel.core.entity.process.UserTask;
import com.camel.dwsurvey.bpm.exceptions.ProcessNotFoundException;
import com.camel.dwsurvey.bpm.mapper.WorkFlowMapper;
import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.camel.dwsurvey.bpm.service.BpmService;
import com.camel.dwsurvey.bpm.utils.ActivitiObj2HashMapUtils;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.apache.commons.lang3.ObjectUtils;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author baily
 */
@Service
public class BpmServiceImpl implements BpmService {

    public static final String PROCESS_NAME_SUFFIX = ".bpmn";

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private WorkFlowMapper mapper;

    @Override
    public Deployment deploy(Integer id) {
        WorkFlow workFlow = mapper.selectById(id);
        DeploymentBuilder builder = repositoryService.createDeployment();
        builder.addString(workFlow.getName() + PROCESS_NAME_SUFFIX, workFlow.getFlow());
        builder.name(workFlow.getName()).category(workFlow.getFlowType().toString());
        Deployment deployment = builder.deploy();
        WorkFlow workFlow1 = new WorkFlow();
        workFlow1.setId(id);
        workFlow1.setStatus(2);
        mapper.updateById(workFlow1);
        return deployment;
    }

    @Override
    public Deployment deploy(String resourceName, String text) {
        return null;
    }

    @Override
    public List definition(String key) {
        ActivitiObj2HashMapUtils instance = ActivitiObj2HashMapUtils.getInstance();
         List<ProcessDefinition> processDefinitions = repositoryService.createProcessDefinitionQuery().processDefinitionKey(key).orderByProcessDefinitionVersion().desc().list();
        List result = new ArrayList();
        processDefinitions.forEach(processDefinition -> {
            result.add(instance.processDefinition2Map(processDefinition));
        });
        return result;
    }

    @Override
    public List queryTask(String key) {
        TaskQuery query = taskService.createTaskQuery();
        query.active().taskAssignee(key);
        List list = new ArrayList();
        query.list().forEach(task -> {
            Map<String, Object> map = new HashMap<>(16);
            map.put("id", task.getId());
            map.put("assignee", task.getAssignee());
            map.put("name", task.getName());
            map.put("description", task.getDescription());
            list.add(map);
        });
        return list;
    }

    @Override
    public PageInfo<Deployment> defWorkflows(WorkFlow entity) {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery().orderByProcessDefinitionVersion().latestVersion().desc().list();
        List result = new ArrayList();
        PageInfo<Deployment> dep = new PageInfo<>();
        dep.setPageNum(entity.getPageNum());
        dep.setPageSize(entity.getPageSize());
        dep.setTotal(list.size());
        ActivitiObj2HashMapUtils instance = ActivitiObj2HashMapUtils.getInstance();
        list.forEach(definition -> {
            result.add(instance.processDefinition2Map(definition));
        });
        dep.setList(result);
        return dep;
    }

    @Override
    public List queryTaskByGroupId(List<String> groupId) {
        TaskQuery query = taskService.createTaskQuery();
        List<Task> tasks = query.taskCandidateGroupIn(groupId).list();
        return tasks;
    }

    @Override
    public boolean apply(String busniessKey, String flowKey) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(flowKey, busniessKey);
        return ObjectUtils.allNotNull(instance);
    }

    @Override
    public boolean applyById(String busniessKey, String flowId) {
        ProcessInstance instance = runtimeService.startProcessInstanceById(flowId, busniessKey);
        return ObjectUtils.allNotNull(instance);
    }

    @Override
    public List<Task> current(String busniessKey, String processDifinitionKey) {
        ProcessInstance instance =runtimeService.createProcessInstanceQuery().processInstanceBusinessKey(busniessKey, processDifinitionKey).active().singleResult();
        if(org.springframework.util.ObjectUtils.isEmpty(instance)){
            // The current process is empty, and there may be value in the history.
            List<HistoricProcessInstance> hpi = historyService.createHistoricProcessInstanceQuery().processInstanceBusinessKey(busniessKey).list();
            if(!org.springframework.util.ObjectUtils.isEmpty(hpi)){
                return new ArrayList<>();
            }
            throw new ProcessNotFoundException();
        }else {
            return taskService.createTaskQuery().processInstanceId(instance.getId()).active().list();
        }
    }
}
