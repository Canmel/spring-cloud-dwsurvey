package com.camel.oauth.server.config;

import com.camel.entity.MyUserDetails;
import com.camel.oauth.server.utils.SerizlizeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.io.Serializable;

public class JwtAccessToken extends JwtAccessTokenConverter {
    /**
     * 生成token
     *
     * @param accessToken
     * @param authentication
     * @return
     */
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        DefaultOAuth2AccessToken defaultOAuth2AccessToken = new DefaultOAuth2AccessToken(accessToken);
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        OAuth2AccessToken oAuth2AccessToken = super.enhance(defaultOAuth2AccessToken, authentication);
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set("accessToken:" + myUserDetails.getUsername(), SerizlizeUtil.serialize(accessToken));
        return oAuth2AccessToken;
    }

    @Autowired
    private RedisTemplate redisTemplate;
}
