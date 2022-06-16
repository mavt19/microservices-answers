package com.bns.microservices.answers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroservicesAnswersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesAnswersApplication.class, args);
	}

}
