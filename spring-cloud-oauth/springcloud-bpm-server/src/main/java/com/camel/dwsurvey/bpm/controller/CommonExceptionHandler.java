package com.camel.dwsurvey.bpm.controller;

import com.camel.core.entity.Result;
import com.camel.core.enums.ResultEnum;
import com.camel.core.utils.ResultUtil;
import org.activiti.engine.ActivitiObjectNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@RestController
public class CommonExceptionHandler {

    @ExceptionHandler(ActivitiObjectNotFoundException.class)
    public Result numberFormatException(HttpServletResponse response){
        response.setStatus(ResultEnum.BAD_REQUEST.getCode());
        return ResultUtil.notFound("未找到流程");
    }
}