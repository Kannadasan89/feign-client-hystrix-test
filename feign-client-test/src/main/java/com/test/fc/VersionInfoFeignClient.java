package com.test.fc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name = "VersionInfoFeignClient", url = "http://localhost:8080")
public interface VersionInfoFeignClient {
	
	@GetMapping(path = "/getversioninfo")
	public int getServiceVersionInfo(); 

}
