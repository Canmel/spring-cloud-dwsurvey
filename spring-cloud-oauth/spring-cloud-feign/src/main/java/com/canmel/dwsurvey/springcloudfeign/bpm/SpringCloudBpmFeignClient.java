package com.canmel.dwsurvey.springcloudfeign.bpm;

import com.camel.core.entity.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "springcloud-bpm-server")
public interface SpringCloudBpmFeignClient {

    @GetMapping("/flow/defWorkflows")
    Result apply(String busniessKey, String flowKey);
}
