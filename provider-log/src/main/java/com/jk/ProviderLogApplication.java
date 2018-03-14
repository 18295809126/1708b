package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProviderLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderLogApplication.class, args);
	}
}
