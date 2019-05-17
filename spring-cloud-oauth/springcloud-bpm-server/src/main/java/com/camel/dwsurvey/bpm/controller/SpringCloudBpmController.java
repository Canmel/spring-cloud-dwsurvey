package com.camel.dwsurvey.bpm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.dwsurvey.bpm.model.WorkFlow;
import com.camel.dwsurvey.bpm.service.BpmService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flow")
public class SpringCloudBpmController {
    @Autowired
    private ProcessEngine engine;

    @Autowired
    private BpmService service;

    /**
     部署
     @return
     */
    @GetMapping("/deploy/{id}")
    public Result deploy(@PathVariable Integer id){
        Deployment deployment = service.deploy(id);
        return ResultUtil.success("部署完成" + deployment.getId(), deployment);
    }

    /**
     查询流程定义
     @param key
     @return
     */
    @GetMapping("/def/{key}")
    public Result definition(@PathVariable String key){
        List result = service.definition(key);
        if(CollectionUtils.isEmpty(result)){
            return ResultUtil.success("未找到相关流程", result);
        }
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

    /**
     根据用户,查询当前任务
     @param assignee
     @return
     */
    @GetMapping("/task/{assignee}")
    public Result queryTask(@PathVariable String assignee){
        System.out.println(SecurityContextHolder.getContext().getAuthentication());
        List list = service.queryTask(assignee);
        if(CollectionUtils.isEmpty(list)){
            return ResultUtil.success("未找到相关流程", list);
        }
        return ResultUtil.success("查询成功", list);
    }



    @GetMapping("/index")
    public String index(){
        return "bpm服务启动成功";
    }
}
