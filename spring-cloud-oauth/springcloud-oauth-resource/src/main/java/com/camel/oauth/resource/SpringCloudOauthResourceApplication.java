package com.camel.oauth.resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 *　　　　　　　 ┏┓    ┏┓+ +
 *　　　　　　　┏┛┻━━━━┛┻┓ + +
 *　　　　　　　┃        ┃ 　springcloud oauth 资源服务器
 *　　　　　　　┃     ━  ┃ ++ + + +
 *           ████━████ ┃+
 *　　　　　　　┃        ┃ +
 *　　　　　　　┃   ┻    ┃
 *　　　　　　　┃        ┃ + +
 *　　　　　　　┗━┓   ┏━━┛
 *　　　　　　　  ┃   ┃　　　　　　　　　　
 *　　　　　　　  ┃   ┃ + + + +
 *　　　　　　　  ┃   ┃　　　Code is far away from bug with the animal protecting　　　　　　　
 *　　　　　　　  ┃   ┃+ 　　　　神兽保佑,代码无bug　　
 *　　　　　　　  ┃   ┃
 *　　　　　　　  ┃   ┃　　+　　　　　　　　　@author baily
 *　　　　　　　  ┃   ┗━━━━━━━┓ + +
 *　　　　　　　  ┃           ┣┓
 *　　　　　　　  ┃           ┏┛
 *              ┗┓┓┏━━━━━┳┓┏┛ + + + +
 *               ┃┫┫     ┃┫┫
 *               ┗┻┛     ┗┻┛+ + + +
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("com.camel.oauth.resource.mapper")
public class SpringCloudOauthResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudOauthResourceApplication.class, args);
    }
}
