package com.camel.getway;

import com.camel.getway.filters.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 *　　　　　　　 ┏┓    ┏┓+ +
 *　　　　　　　┏┛┻━━━━┛┻┓ + +
 *　　　　　　　┃        ┃ 　springcloud zuul 网关
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
 *　　　　　　　  ┃   ┃　　+　　　　　　　　　
 *　　　　　　　  ┃   ┗━━━━━━━┓ + +
 *　　　　　　　  ┃           ┣┓
 *　　　　　　　  ┃           ┏┛
 *              ┗┓┓┏━━━━━┳┓┏┛ + + + +
 *               ┃┫┫     ┃┫┫
 *               ┗┻┛     ┗┻┛+ + + +
 */
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudZuulGetwayApplication {
	public static void main(String[] args) {
        SpringApplication.run(SpringCloudZuulGetwayApplication.class, args);
    }    
    
    @Bean
    public SimpleFilter simpleFilter() {
      return new SimpleFilter();
    }
}
