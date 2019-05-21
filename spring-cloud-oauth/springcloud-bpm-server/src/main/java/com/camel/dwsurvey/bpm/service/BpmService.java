package com.camel.dwsurvey.bpm.service;

import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.task.Task;

import java.io.InputStream;
import java.util.List;

/**
 * @author baily
 */
public interface BpmService {
    /**
     * 部署流程
     * @param path
     * @return
     */
    Deployment deploy(Integer path);

    /**
     * 部署流程
     * @param resourceName
     * @param text
     * @return
     */
    Deployment deploy(String resourceName, String text);

    /**
     * 通过KEY获取流程定义
     * @param key
     * @return
     */
    List definition(String key);

    /**
     * 通过KEY获取任务
     * @param key
     * @return
     */
    List queryTask(String key);

    /**
     * 通过groupId获取任务列表
     * @param groupId
     * @return
     */
    List queryTaskByGroupId(List<String> groupId);

    /**
     * 获取流程定义分页查询
     * @param entity
     * @return
     */
    PageInfo<Deployment> defWorkflows(WorkFlow entity);

    /**
     通过流程KEY发起流程，并绑定业务key
     @param busniessKey
     @param flowKey
     @return
     */
    boolean apply(String busniessKey, String flowKey);

    /**
     通过流程ID发起流程，并绑定业务key
     @param busniessKey
     @param flowId
     @return
     */
    boolean applyById(String busniessKey, String flowId);

    /**
     查询当前流程
     @param busniessKey
     @param processDifinitionKey
     @return
     */
    List<Task> current(String busniessKey, String processDifinitionKey);

    /**
     流程追踪图
     @param taskId 任务ID
     @return
     */
    InputStream processTraceImage(String taskId);
}
