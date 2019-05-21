package com.camel.dwsurvey.bpm.service.impl;

import com.camel.core.entity.process.UserTask;
import com.camel.dwsurvey.bpm.exceptions.ProcessNotFoundException;
import com.camel.dwsurvey.bpm.mapper.WorkFlowMapper;
import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.camel.dwsurvey.bpm.service.BpmService;
import com.camel.dwsurvey.bpm.utils.ActivitiObj2HashMapUtils;
import com.github.pagehelper.PageInfo;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.bpmn.model.FlowNode;
import org.activiti.bpmn.model.SequenceFlow;
import org.activiti.engine.*;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.activiti.image.ProcessDiagramGenerator;
import org.apache.commons.lang3.ObjectUtils;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.InputStream;
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

    @Autowired
    private ProcessEngineConfiguration processEngineConfiguration;

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

    @Override
    public InputStream processTraceImage(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstanceId = "";
        if (!org.springframework.util.ObjectUtils.isEmpty(task)) {
            processInstanceId = task.getProcessInstanceId();
        } else {
            processInstanceId = taskId;
        }

        // 获取历史流程实例
        HistoricProcessInstance historicProcessInstance = historyService.createHistoricProcessInstanceQuery()
                .processInstanceId(processInstanceId).singleResult();

        // 获取流程中已经执行的节点，按照执行先后顺序排序
        List<HistoricActivityInstance> historicActivityInstances = historyService.createHistoricActivityInstanceQuery().processInstanceId(processInstanceId)
                .orderByHistoricActivityInstanceId().asc().list();

        // 高亮已经执行流程节点ID集合
        List<String> highLightedActivitiIds = new ArrayList<>();
        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            highLightedActivitiIds.add(historicActivityInstance.getActivityId());
        }

        List<HistoricProcessInstance> historicFinishedProcessInstances = historyService.createHistoricProcessInstanceQuery().processInstanceId(processInstanceId).finished()
                .list();

        processEngineConfiguration.setXmlEncoding("utf-8");
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");
        // 生成图片的工具
        ProcessDiagramGenerator processDiagramGenerator = processEngineConfiguration.getProcessDiagramGenerator();

        BpmnModel bpmnModel = repositoryService.getBpmnModel(historicProcessInstance.getProcessDefinitionId());
        // 高亮流程已发生流转的线id集合
        List<String> highLightedFlowIds = getHighLightedFlows(bpmnModel, historicActivityInstances);

        // 使用默认配置获得流程图表生成器，并生成追踪图片字符流
        InputStream imageStream = processDiagramGenerator.generateDiagram(bpmnModel, "png", highLightedActivitiIds, highLightedFlowIds, "宋体", "宋体", null, 2.0);

        return imageStream;
    }

    /**
     * 获取高亮流程
     * @param bpmnModel
     * @param historicActivityInstances
     * @return
     */
    private static List<String> getHighLightedFlows(BpmnModel bpmnModel, List<HistoricActivityInstance> historicActivityInstances) {
        // 高亮流程已发生流转的线id集合
        List<String> highLightedFlowIds = new ArrayList<>();
        // 全部活动节点
        List<FlowNode> historicActivityNodes = new ArrayList<>();
        // 已完成的历史活动节点
        List<HistoricActivityInstance> finishedActivityInstances = new ArrayList<>();

        for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
            FlowNode flowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(historicActivityInstance.getActivityId());
            historicActivityNodes.add(flowNode);
            if (historicActivityInstance.getEndTime() != null) {
                finishedActivityInstances.add(historicActivityInstance);
            }
        }

        FlowNode currentFlowNode = null;
        FlowNode targetFlowNode = null;
        // 遍历已完成的活动实例，从每个实例的outgoingFlows中找到已执行的
        for (HistoricActivityInstance currentActivityInstance : finishedActivityInstances) {
            // 获得当前活动对应的节点信息及outgoingFlows信息
            currentFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(currentActivityInstance.getActivityId());
            List<SequenceFlow> sequenceFlows = currentFlowNode.getOutgoingFlows();

            /**
             * 遍历outgoingFlows并找到已已流转的 满足如下条件认为已已流转： 1.当前节点是并行网关或兼容网关，则通过outgoingFlows能够在历史活动中找到的全部节点均为已流转 2.当前节点是以上两种类型之外的，通过outgoingFlows查找到的时间最早的流转节点视为有效流转
             */
            if ("parallelGateway".equals(currentActivityInstance.getActivityType()) || "inclusiveGateway".equals(currentActivityInstance.getActivityType())) {
                // 遍历历史活动节点，找到匹配流程目标节点的
                for (SequenceFlow sequenceFlow : sequenceFlows) {
                    targetFlowNode = (FlowNode) bpmnModel.getMainProcess().getFlowElement(sequenceFlow.getTargetRef());
                    if (historicActivityNodes.contains(targetFlowNode)) {
                        highLightedFlowIds.add(targetFlowNode.getId());
                    }
                }
            } else {
                List<Map<String, Object>> tempMapList = new ArrayList<>();
                for (SequenceFlow sequenceFlow : sequenceFlows) {
                    for (HistoricActivityInstance historicActivityInstance : historicActivityInstances) {
                        if (historicActivityInstance.getActivityId().equals(sequenceFlow.getTargetRef())) {
                            Map<String, Object> map = new HashMap<>(16);
                            map.put("highLightedFlowId", sequenceFlow.getId());
                            map.put("highLightedFlowStartTime", historicActivityInstance.getStartTime().getTime());
                            tempMapList.add(map);
                        }
                    }
                }
                if (!CollectionUtils.isEmpty(tempMapList)) {
                    // 遍历匹配的集合，取得开始时间最早的一个
                    long earliestStamp = 0L;
                    String highLightedFlowId = null;
                    for (Map<String, Object> map : tempMapList) {
                        long highLightedFlowStartTime = Long.valueOf(map.get("highLightedFlowStartTime").toString());
                        if (earliestStamp == 0 || earliestStamp >= highLightedFlowStartTime) {
                            highLightedFlowId = map.get("highLightedFlowId").toString();
                            earliestStamp = highLightedFlowStartTime;
                        }
                    }
                    highLightedFlowIds.add(highLightedFlowId);
                }
            }
        }
        return highLightedFlowIds;
    }
}
