package com.sangita.smartschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
@EnableJpaRepositories("com.sangita.smartschool.repository")
@EntityScan("com.sangita.smartschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SmartschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartschoolApplication.class, args);
	}

}
