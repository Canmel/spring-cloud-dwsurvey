package com.camel.dwsurvey.system.controller;

import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.camel.redis.entity.RedisUser;
import com.camel.redis.utils.SerizlizeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.security.Principal;
import java.util.HashMap;
import java.util.Set;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Resource
    private ConsumerTokenServices consumerTokenServices;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/token")
    public String revokeToken(Principal principal, HttpSession session) {
        session.invalidate();
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        byte[] cu = (byte[]) operations.get("CURRENT_USER");
        RedisUser sysUser = (RedisUser) SerizlizeUtil.unserizlize(cu);
        Set set = redisTemplate.keys("*");
//        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        byte[] cu1 = (byte[]) operations.get("access");
//        RedisUser sysUser = (RedisUser) SerizlizeUtil.unserizlize(cu);
//        session.removeAttribute("org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository.CSRF_TOKEN");
//        session.removeAttribute("SPRING_SECURITY_CONTEXT");
        return "注销成功";
    }

    @RequestMapping(value = "/isValid", method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request) {
        //简化if-else表达式（其实很多地方可以简化的，这里为了方便新手朋友可以看得顺畅点，我尽量不简化）
        return request.isRequestedSessionIdValid() ? "ok" : "no";
    }

    /**
     * 注销登录
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpSession session, HttpServletRequest request, SessionStatus sessionStatus) {
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            username = "testSessionRedis|" + System.currentTimeMillis();
            session.setAttribute("username", username);
        }
        System.out.println("访问端口：" + request.getServerPort());
        return username;
    }
}
