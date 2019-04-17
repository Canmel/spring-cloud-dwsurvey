package com.camel.oauth.resource.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.oauth.resource.model.TSurveyDirectory;
import com.camel.oauth.resource.service.TSurveyDirectoryService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2019-04-17
 */
@RestController
@RequestMapping("/tSurveyDirectory")
public class TSurveyDirectoryController {
    @Autowired
    private TSurveyDirectoryService tSurveyDirectoryService;

    @GetMapping
    public Result pageQuery(TSurveyDirectory tSurveyDirectory){
       PageInfo<TSurveyDirectory> pageInfo = tSurveyDirectoryService.pageQuery(tSurveyDirectory);
        return ResultUtil.success(pageInfo);
    }
}

