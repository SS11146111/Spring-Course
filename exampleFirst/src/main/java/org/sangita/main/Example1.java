package org.sangita.main;

import org.sangita.beans.Vehicle;
import org.sangita.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example1 {

    public static void main(String[] args) {

        /* In the below three lines we are simply creating object using new operator and have not done any configuration.
        * This Honda City vehicle is not going to be tracked by the spring context*/
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda City");
        System.out.println("Vehicle name from non-spring context is: "+vehicle.getName());

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Vehicle name from Spring Context is: " + veh.getName());

        String msg1 = context.getBean(String.class);
        System.out.println("Message 1: " + msg1);

        Integer num1 = context.getBean(Integer.class);
        System.out.println("Number 1: " + num1);

    }
}
