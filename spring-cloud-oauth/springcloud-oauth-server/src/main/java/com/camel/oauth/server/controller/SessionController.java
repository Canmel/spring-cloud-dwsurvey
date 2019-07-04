package com.camel.oauth.server.controller;

import com.camel.redis.utils.SerizlizeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.support.collections.RedisStore;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.security.Principal;
import java.util.Collection;
import java.util.Iterator;

@RestController
@RequestMapping("/session")
public class SessionController {

    @Autowired
    @Qualifier("consumerTokenServices")
    ConsumerTokenServices consumerTokenServices;

    @Autowired
    private RedisTemplate redisTemplate;


    @Autowired
    private RedisTokenStore redisTokenStore;

    @GetMapping("/logout")
    public String logout(Principal principal) {
        Collection<OAuth2AccessToken> auth2AccessTokens = redisTokenStore.findTokensByClientIdAndUserName("first", "admin@camel.com");

        Iterator iterable = auth2AccessTokens.iterator();
        if(iterable.hasNext()){
            OAuth2AccessToken oAuth2AccessToken = (OAuth2AccessToken) iterable.next();
            redisTokenStore.removeAccessToken(oAuth2AccessToken.getValue());
            redisTokenStore.removeAccessToken(oAuth2AccessToken);
            consumerTokenServices.revokeToken(oAuth2AccessToken.getValue());
        }
        return "成功";
    }
}
