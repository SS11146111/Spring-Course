package com.sangita.smartschool.service;

import com.sangita.smartschool.controller.ContactController;
import com.sangita.smartschool.model.Contact;
//import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */

@Slf4j
@Service
public class ContactService {

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */

    //private static Logger log = LoggerFactory.getLogger(ContactService.class);

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = true;
        //TODO - Need to persist the data into the DB table
        log.info(contact.toString());
        return isSaved;
    }

}
