package com.camel.oauth.server.controller;

import com.camel.core.entity.Result;
import com.camel.core.utils.ResultUtil;
import org.springframework.security.core.token.TokenService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.security.Principal;

@FrameworkEndpoint
public class SessionController {

    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @Resource
    private TokenService tokenService;

    @RequestMapping(method = RequestMethod.DELETE, value = "/oauth/token")
    @ResponseBody
    public String revokeToken(String access_token) {
        
        if (consumerTokenServices.revokeToken(access_token)){
            return "注销成功";
        }else{
            return "注销失败";
        }
    }
}
