package org.sangita.services;

import org.sangita.interfaces.LogAspect;
import org.sangita.interfaces.Speakers;
import org.sangita.interfaces.Tyres;
import org.sangita.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class VehicleServices {

    private Logger logger = Logger.getLogger(VehicleServices.class.getName());

    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    @LogAspect
    public String playMusic(boolean vehicleStarted, Song song){

        return speakers.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){

        //the below exception is to test @AfterThrowing
        //throw new NullPointerException("Damn!Null pointer exception occurred!!");

        //the below return statement to test @AfterReturning
        return tyres.rotate();
    }

    public String applyBrake(boolean vehicleStarted){

        return tyres.stop();
    }

    public Speakers getSpeakers() {
        return speakers;
    }

    public void setSpeakers(Speakers speakers) {
        this.speakers = speakers;
    }

    public Tyres getTyres() {
        return tyres;
    }

    @Autowired
    public void setTyres(Tyres tyres) {
        this.tyres = tyres;
    }
}
