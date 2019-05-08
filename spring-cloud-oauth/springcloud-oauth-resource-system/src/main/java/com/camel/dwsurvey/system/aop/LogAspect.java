package com.camel.dwsurvey.system.aop;


import com.camel.dwsurvey.system.annotation.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogAspect.class);

    @After(("execution(* com.camel..*.*(..)) && @annotation(log)"))
    public void doAfterAdvice(JoinPoint joinPoint, Log log) {
        LOGGER.info("==============================================用户操作日志-后置通知开始执行......==========================================");

        System.out.println(log.moduleName());
        System.out.println(log.option());

        LOGGER.info("==============================================用户操作日志-后置通知结束执行......==========================================");
    }
}
