package com.ms.userservices.controllers;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.userservices.models.UserDetails;

@RestController
@RequestMapping("/users")
public class UserController {

	Logger LOG = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/info")
	public String getInfo() {
		LOG.info("User Services are running...");
		return "from-user-api:User Services are running...";
	}

	@GetMapping
	public List<UserDetails> getMovieRating() {
		List<UserDetails> users = Arrays.asList(new UserDetails(1, "Ram", "Mohan"), new UserDetails(2, "Ram", "Mohan"));
		return users;
	}

	@GetMapping("/{userId}")
	public UserDetails getUserRatings(@PathVariable("userId") long userId) {
		return new UserDetails(userId, "Ram", "Mohan");
	}

}