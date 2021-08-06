package com.vinodh.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.*")
@EnableMongoRepositories("com.vinodh.repository")
public class AlarmServiceApplication {
	private static final Logger log = LoggerFactory.getLogger(AlarmServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AlarmServiceApplication.class, args);
		log.info("AdvancedSearchApplication started successfully...");
	}

}
