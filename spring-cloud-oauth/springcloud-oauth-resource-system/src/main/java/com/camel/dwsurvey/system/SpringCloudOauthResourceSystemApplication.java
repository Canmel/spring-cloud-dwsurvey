package com.camel.dwsurvey.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 　　　　　　　 ┏┓    ┏┓+ +
 * 　　　　　　　┏┛┻━━━━┛┻┓ + +
 * 　　　　　　　┃        ┃ 　  系统权限项目入口
 * 　　　　　　　┃     ━  ┃ ++ + + +
 * 　　　　　 　████━████ ┃+
 * 　　　　　　　┃        ┃ +
 * 　　　　　　　┃   ┻    ┃
 * 　　　　　　　┃        ┃ + +
 * 　　　　　　　┗━┓   ┏━━┛
 * 　　　　　　　  ┃   ┃
 * 　　　　　　　  ┃   ┃ + + + +
 * 　　　　　　　  ┃   ┃　　　Code is far away from bug with the animal protecting
 * 　　　　　　　  ┃   ┃+ 　　　　神兽保佑,代码无bug
 * 　　　　　　　  ┃   ┃
 * 　　　　　　　  ┃   ┃　　+
 * 　　　　　　　  ┃   ┗━━━━━━━┓ + +
 * 　　　　　　　  ┃           ┣┓
 * 　　　　　　　  ┃           ┏┛
 * 　　　　　　　  ┗┓┓┏━━━━━┳┓┏┛ + + + +
 * 　　　　　　　   ┃┫┫     ┃┫┫
 * 　　　　　　　   ┗┻┛     ┗┻┛+ + + +
 * @author baily
 */
@MapperScan("com.canmel.dwsurvey.system.mapper")
@EnableEurekaClient
@SpringBootApplication
@EnableRedisHttpSession
public class SpringCloudOauthResourceSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauthResourceSystemApplication.class, args);
	}

}
