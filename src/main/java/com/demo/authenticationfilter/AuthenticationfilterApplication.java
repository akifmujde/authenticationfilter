package com.demo.authenticationfilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AuthenticationfilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationfilterApplication.class, args);
	}

}
