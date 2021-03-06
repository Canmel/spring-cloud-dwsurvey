package com.canmel.dwsurvey.springcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author baily
 */
@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApplication.class, args);
	}

}
