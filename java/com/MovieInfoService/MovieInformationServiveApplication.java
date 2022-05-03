package com.MovieInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInformationServiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInformationServiveApplication.class, args);
	}

}
