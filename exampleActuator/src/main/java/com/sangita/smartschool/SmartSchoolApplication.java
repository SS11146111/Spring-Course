package com.sangita.smartschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.sangita.smartschool.repository")
@EntityScan("com.sangita.smartschool.model")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
public class SmartSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartSchoolApplication.class, args);
	}

}
