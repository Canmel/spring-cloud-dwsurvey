package com.camel.dwsurvey.system.config;

import com.camel.core.entity.Result;
import com.camel.core.enums.ResultEnum;
import com.camel.core.utils.ResultUtil;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/** @author baily */
@ControllerAdvice
@RestController
public class CommonExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public Result numberFormatException(HttpServletResponse response){
        response.setStatus(ResultEnum.BAD_REQUEST.getCode());
        return ResultUtil.error(ResultEnum.BAD_REQUEST);
    }

    @ExceptionHandler(RedisConnectionFailureException.class)
    public Result redisConnectionException(HttpServletResponse response){
        response.setStatus(ResultEnum.BAD_REQUEST.getCode());
        return ResultUtil.error(ResultEnum.SERVICE_ERROR.getCode(), "未发现Redis服务!请通知管理员，这可能导致日志记录失败或部分丢失");
    }
}
