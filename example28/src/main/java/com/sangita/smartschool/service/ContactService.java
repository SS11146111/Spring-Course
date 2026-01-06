package com.sangita.smartschool.service;

import com.sangita.smartschool.constants.SmartSchoolConstants;
import com.sangita.smartschool.controller.ContactController;
import com.sangita.smartschool.model.Contact;
//import lombok.extern.slf4j.Slf4j;
import com.sangita.smartschool.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */

@Slf4j
@Service
//@RequestScope
//@SessionScope
//@ApplicationScope
public class ContactService {

    /**
     * Save Contact Details into DB
     * @param contact
     * @return boolean
     */

    //private static Logger log = LoggerFactory.getLogger(ContactService.class);

    //private int counter = 0;

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact service bean initialised");
    }

    public boolean saveMessageDetails(Contact contact){
        /*boolean isSaved = true;
        log.info(contact.toString());
        return isSaved;*/

        boolean isSaved = false;
        contact.setStatus(SmartSchoolConstants.OPEN);
        contact.setCreatedBy(SmartSchoolConstants.ANONYMOUS);
        contact.setCreatedAt(LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0)
        {
            isSaved = true;
        }

        return isSaved;
    }

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(SmartSchoolConstants.OPEN);
        return contactMsgs;
    }

    /*public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }*/
}
