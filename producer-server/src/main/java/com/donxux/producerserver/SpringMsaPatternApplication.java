package com.donxux.producerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMsaPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMsaPatternApplication.class, args);
	}

}
