package com.camel.dwsurvey.bpm.service;

import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.repository.Deployment;

import java.util.List;

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
}
