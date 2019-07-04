package com.camel.getway.controller;

import com.camel.entity.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.client.RestOperations;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

/**
 * 　　　　　　　 ┏┓　　　┏┓
 * 　　　　　　　┏┛┻━━━━━┛┻┓
 * 　　　　　　　┃         ┃ 　  站点控制器   @author baily
 * 　　　　　　　┃    ━    ┃
 * 　　　　　　　┃  >   <  ┃
 * 　　　　　　　┃         ┃
 * 　　　　　　　┃... ⌒ ...┃
 * 　　　　　　　┃         ┃
 *             ┗━┓     ┏━┛
 *               ┃     ┃　Code is far away from bug with the animal protecting　　　　　　　　　　
 *               ┃     ┃   神兽保佑,代码无bug
 *               ┃     ┃　　　　　　　　　　　
 *               ┃     ┃  　　　　　　
 *               ┃     ┃
 *               ┃     ┃　　　　　　　　　　　
 *               ┃     ┗━━━━┓
 *               ┃          ┣┓
 *               ┃          ┏┛
 *               ┗┓┓┏━━━━┳┓┏┛
 *                ┃┫┫    ┃┫┫
 *                ┗┻┛    ┗┻┛
 */
@RestController
public class CloudSiteController {

    @Autowired
    private RestOperations restOperations;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/")
    @ResponseBody
    public String hello(DefaultOAuth2ClientContext oAuth2ClientContext) {
        return "Hello From Auth-Client!";
    }

    @GetMapping("/personInfo")
    public String person(Principal principal, HttpSession session, SessionStatus sessionStatus, HttpServletResponse response) throws IOException {
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) principal;
        OAuth2AuthenticationDetails auth2AuthenticationDetails = (OAuth2AuthenticationDetails) oAuth2Authentication.getDetails();
        String token = auth2AuthenticationDetails.getTokenValue();

        response.sendRedirect("");
        session.invalidate();
        sessionStatus.setComplete();
        DefaultAccessTokenRequest request = new DefaultAccessTokenRequest();
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//        operations.get(principal)
        return "成功";

    }

}
