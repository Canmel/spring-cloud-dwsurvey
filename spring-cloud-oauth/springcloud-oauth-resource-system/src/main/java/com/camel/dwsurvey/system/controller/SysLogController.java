package com.camel.dwsurvey.system.controller;


import com.baomidou.mybatisplus.service.IService;
import com.camel.core.BaseCommonController;
import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import com.camel.dwsurvey.system.model.SysLog;
import com.camel.dwsurvey.system.service.SysLogService;
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
 * @since 2019-05-09
 */
@RestController
@RequestMapping("/sysLog")
public class SysLogController extends BaseCommonController {
    @Autowired
    private SysLogService service;

    @GetMapping
    public Result index(SysLog entity){
        return ResultUtil.success(service.pageQuery(entity));
    }

    @Override
    public IService getiService() {
        return service;
    }

    @Override
    public String getMouduleName() {
        return "日志";
    }
}

