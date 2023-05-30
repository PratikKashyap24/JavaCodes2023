package com.url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

//@ComponentScan(basePackages = "com.url.SpringUrlShortnerApplication")
//@EnableAutoConfiguration
//@Configuration
//@EntityScan
@SpringBootApplication
@EntityScan("com.url.entity")
public class SpringUrlShortnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringUrlShortnerApplication.class, args);
	}

}
