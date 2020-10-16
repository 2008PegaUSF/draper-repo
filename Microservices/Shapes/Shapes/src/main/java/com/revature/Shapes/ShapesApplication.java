package com.revature.Shapes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*
 * For our service registry, we need to run a Spring Boot application, to host the registry 
 * 
 * Consul is a popular service registry that run on an another app entirely, in the background. I won't be showing you that. 
 */

@EnableEurekaServer
@SpringBootApplication
public class ShapesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShapesApplication.class, args);
	}

}
