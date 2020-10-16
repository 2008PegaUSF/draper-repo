package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShapesService2Application {

	public static void main(String[] args) {
		SpringApplication.run(ShapesService2Application.class, args);
	}

}
