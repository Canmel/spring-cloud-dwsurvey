package com.camel.oauth.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.session.Session;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    private DefaultTokenServices defaultTokenServices;

    @GetMapping("/logout")
    public String logout(HttpSession session, Principal principal){
//        defaultTokenServices.getAccessToken()
        System.out.println(session);
        return "ok";
    }
}
