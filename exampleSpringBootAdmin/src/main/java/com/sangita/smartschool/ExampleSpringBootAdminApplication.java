package com.sangita.smartschool;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class ExampleSpringBootAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSpringBootAdminApplication.class, args);
	}

}
