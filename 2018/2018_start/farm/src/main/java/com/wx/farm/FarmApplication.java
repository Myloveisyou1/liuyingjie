package com.wx.farm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FarmApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(FarmApplication.class, args);
	}
}
