package com.camel.dwsurvey.bpm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringCloudBpmController {
    @GetMapping("/index")
    public String index(){
        return "bpm服务启动成功";
    }
}
