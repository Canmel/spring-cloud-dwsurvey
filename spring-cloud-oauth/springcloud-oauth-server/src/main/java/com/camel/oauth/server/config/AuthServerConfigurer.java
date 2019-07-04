package com.camel.oauth.server.config;

import com.camel.oauth.server.service.impl.MyUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import java.security.KeyPair;
import java.util.concurrent.TimeUnit;

/**
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O				授权服务配置 @author baily
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
            佛祖保佑       永无BUG
**/
@Configuration
@EnableAuthorizationServer
@Order(6)
public class AuthServerConfigurer extends AuthorizationServerConfigurerAdapter {

    @Value("${jwt.certificate.store.file}")
    private Resource keystore;

    @Value("${jwt.certificate.store.password}")
    private String keystorePassword;

    @Value("${jwt.certificate.key.alias}")
    private String keyAlias;

    @Value("${jwt.certificate.key.password}")
    private String keyPassword;

    @Autowired
    private MyUserDetailsServiceImpl userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("first").secret("passwordforauthserver")
                .redirectUris("http://127.0.0.1:8080/", "http://127.0.0.1:4200/").authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token",
                "password", "implicit")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)).refreshTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2))
                .and()
                .withClient("second").secret("passwordforauthserver")
                .redirectUris("http://127.0.0.1:8081/").authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token",
                "password", "implicit")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds(30)).refreshTokenValiditySeconds((int) TimeUnit.HOURS.toSeconds(2));
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailsService);
        endpoints.authenticationManager(authenticationManager).tokenStore(redisTokenStore());
        endpoints.reuseRefreshTokens(true);
    }

    /**
     * redis token 配置
     */
    @Bean
    public TokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keystore, keystorePassword.toCharArray());
        KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyAlias, keyPassword.toCharArray());
        final JwtAccessTokenConverter converter = new JwtAccessToken();
        converter.setKeyPair(keyPair);
        return converter;
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();
    }
}
