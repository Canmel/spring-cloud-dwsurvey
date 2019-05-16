package com.camel.dwsurvey.bpm.service;

import org.activiti.engine.repository.Deployment;

import java.util.List;

public interface BpmService {
    Deployment deploy(String path);

    Deployment deploy(String resourceName, String text);

    List definition(String key);

    List queryTask(String key);

    List queryTaskByGroupId(List<String> groupId);
}
