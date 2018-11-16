package com.test.fc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionInfoTestController {

	@Autowired
	private VersionInfoFeignClient client;

	@GetMapping("/getversioninfo")
	public ResponseEntity<Integer> count() {
		return new ResponseEntity<>(client.getServiceVersionInfo(), HttpStatus.OK);
	}

}
