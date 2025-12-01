package org.sangita.config;

import org.sangita.beans.Person;
import org.sangita.beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = {"org.sangita.implementation",
        "org.sangita.services"})
@ComponentScan(basePackageClasses = {org.sangita.beans.Vehicle.class,
        org.sangita.beans.Person.class})
public class ProjectConfig {

}
