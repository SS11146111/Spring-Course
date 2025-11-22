package org.sangita.main;

import org.sangita.beans.Vehicle;
import org.sangita.config.ProjectConfig;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;
import java.util.function.Supplier;

public class Example8 {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Vehicle volkswagen = new Vehicle();
        volkswagen.setName("Volkswagen");
        Supplier<Vehicle> volkswagenSupplier = () -> volkswagen;

        Supplier<Vehicle> audiSupplier = () -> {
            Vehicle audi = new Vehicle();
            audi.setName("Audi");
            return audi;
        };

        Random random = new Random();
        int randomNumber = random.nextInt(10);
        System.out.println("random number = "+randomNumber);

        if((randomNumber%2)==0)
        {
            context.registerBean("volkswagen", Vehicle.class, volkswagenSupplier);
        }
        else
        {
            context.registerBean("audi", Vehicle.class, audiSupplier);
        }

        Vehicle volksVehicle = null;
        Vehicle audiVehicle = null;

        try{

            volksVehicle = context.getBean("volkswagen",Vehicle.class);
        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException)
        {
            System.out.println("Error while creating volkswagen vehicle");
        }

        try{

            audiVehicle = context.getBean("audi",Vehicle.class);
        }catch(NoSuchBeanDefinitionException noSuchBeanDefinitionException)
        {
            System.out.println("Error while creating audi vehicle");
        }

        if(volksVehicle != null)
        {
            System.out.println("Programming vehicle name from spring context is: "+volksVehicle.getName());
        }else{

            System.out.println("Programming vehicle name from spring context is: "+audiVehicle.getName());
        }
    }
}
