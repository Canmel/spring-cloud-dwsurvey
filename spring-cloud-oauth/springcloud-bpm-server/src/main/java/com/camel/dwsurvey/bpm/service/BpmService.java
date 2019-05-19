package com.camel.dwsurvey.bpm.service;

import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.github.pagehelper.PageInfo;
import org.activiti.engine.repository.Deployment;

import java.util.List;

public interface BpmService {
    Deployment deploy(Integer path);

    Deployment deploy(String resourceName, String text);

    List definition(String key);

    List queryTask(String key);

    List queryTaskByGroupId(List<String> groupId);

    PageInfo<Deployment> defWorkflows(WorkFlow entity);
}
