package com.karsun.kic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Start up class for Spring Boot.
 * 
 * @author Karsun Solutions LLC
 *
 */
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
