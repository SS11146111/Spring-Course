package org.sangita.main;

import org.sangita.beans.Vehicle;
import org.sangita.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example7 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Component Vehicle name from Spring Context is: " + vehicle.getName());
        vehicle.printHello();
        context.close();
    }
}
