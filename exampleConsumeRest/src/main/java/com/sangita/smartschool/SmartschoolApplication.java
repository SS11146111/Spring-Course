package com.sangita.smartschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.sangita.smartschool.proxy")
public class SmartschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartschoolApplication.class, args);
	}

}
