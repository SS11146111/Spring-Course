package com.sangita.smartschool.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        // Permit All Requests inside the Web Application
        http.authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers("/","/home").permitAll()
                                .requestMatchers("/courses").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/holidays/**").permitAll()
                                .requestMatchers("/about").permitAll()
                                .requestMatchers("/saveMsg").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                )
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());


        /*// Deny All Requests inside the Web Application
            http.authorizeHttpRequests(requests -> requests.anyRequest().denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());*/

        return http.build();

    }

}
