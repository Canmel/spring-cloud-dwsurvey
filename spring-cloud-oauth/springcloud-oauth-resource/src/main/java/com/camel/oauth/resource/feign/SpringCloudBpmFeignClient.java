package com.camel.oauth.resource.feign;

import com.camel.core.entity.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author baily
 */
@FeignClient(value = "springcloud-bpm-server")
public interface SpringCloudBpmFeignClient {

    /**
     * 发起流程
     * @param busniessKey   业务      KEY
     * @param flowKey       流程关键字 KEY
     * @return
     */
    @RequestMapping(value = "/flow/apply", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result apply(@RequestParam("busniessKey") String busniessKey, @RequestParam("flowKey") String flowKey);

    /**
     * 发起流程
     * @param busniessKey   业务      KEY
     * @param flowId       流程关键字 KEY
     * @return
     */
    @RequestMapping(value = "/flow/applyById", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result applyById(@RequestParam("busniessKey") String busniessKey, @RequestParam("flowId") String flowId);

    /**
     查询当前流程
     @param busniessKey     业务      KEY
     @param flowKey         流程关键字 KEY
     @return
     */
    @RequestMapping(value = "/flow/current", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    Result current(@RequestParam("busniessKey") String busniessKey, @RequestParam("flowKey") String flowKey);
}
