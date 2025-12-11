package org.sangita.services;

import org.sangita.interfaces.Speakers;
import org.sangita.interfaces.Tyres;
import org.sangita.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class VehicleServices {

    @Autowired
    private Speakers speakers;
    private Tyres tyres;

    public String playMusic(Song song){

        return speakers.makeSound(song);
    }

    public String moveVehicle(){

        return tyres.rotate();
    }

    public String applyBrake(){

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
