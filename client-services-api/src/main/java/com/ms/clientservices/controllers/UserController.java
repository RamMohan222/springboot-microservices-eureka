package com.ms.clientservices.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {

	Logger LOG = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private RestTemplate restClient;

	@GetMapping("/info")
	public String info() {
		LOG.info("info service is running...");
		String response = restClient.getForObject("http://USER-SERVICES-API/users/info", String.class);
		return response;
	}
	
	@GetMapping
	public String fetchAllUsers() {
		String response = restClient.getForObject("http://USER-SERVICES-API/users", String.class);
		return response;
	}

	@GetMapping("/{userId}")
	public String fetchUserByUserId(@PathVariable String userId) {
		String response = restClient.getForObject("http://USER-SERVICES-API/users/" + userId, String.class);
		return response;
	}
}
