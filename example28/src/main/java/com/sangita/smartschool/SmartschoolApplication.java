package com.sangita.smartschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class SmartschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartschoolApplication.class, args);
	}

}
