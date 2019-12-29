package com.ms.clientservices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	Logger LOG = LoggerFactory.getLogger(AppConfig.class);

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		LOG.info("RestTemplate Created...");
		return new RestTemplate();
	}

}
