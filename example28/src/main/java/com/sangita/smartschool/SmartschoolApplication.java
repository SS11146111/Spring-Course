package com.sangita.smartschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.webmvc.autoconfigure.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class SmartschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartschoolApplication.class, args);
	}

}
