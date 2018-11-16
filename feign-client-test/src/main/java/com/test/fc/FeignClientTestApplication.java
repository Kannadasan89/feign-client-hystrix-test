package com.test.fc;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import feign.Client;

@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
public class FeignClientTestApplication {
	
	@Autowired
	private VersionInfoFeignClient client;

	public static void main(String[] args) {
		SpringApplication.run(FeignClientTestApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		try {
			int versionInfo = client.getServiceVersionInfo();
			System.out.println("versionInfo:"+ versionInfo); 
 		} catch(RuntimeException ex) {
 			ex.printStackTrace();
		}
	}
}
