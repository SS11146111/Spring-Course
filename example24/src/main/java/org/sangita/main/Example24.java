package org.sangita.main;

import org.sangita.config.ProjectConfig;
import org.sangita.model.Song;
import org.sangita.services.VehicleServices;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Example24 {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleServices = context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        Song song = new Song();
        song.setTitle("Blank Space");
        song.setSingerName("Taylor Swift");
        String moveVehicleStatus = vehicleServices.moveVehicle();
        String playMusicStatus = vehicleServices.playMusic(song);
        String applyBrakeStatus = vehicleServices.applyBrake();
    }
}
