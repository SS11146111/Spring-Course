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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        //contact.setCreatedBy(SmartSchoolConstants.ANONYMOUS);
        //contact.setCreatedAt(LocalDateTime.now());
        //int result = contactRepository.saveContactMsg(contact);
        Contact savedContact = contactRepository.save(contact);
        /*if(result>0)
        {
            isSaved = true;
        }*/

        if(null!= savedContact && savedContact.getContactId()>0)
        {
            isSaved=true;
        }

        return isSaved;
    }

    /*public List<Contact> findMsgsWithOpenStatus(){
        //List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(SmartSchoolConstants.OPEN);
        List<Contact> contactMsgs = contactRepository.findByStatus(SmartSchoolConstants.OPEN);
        return contactMsgs;
    }*/

    public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                SmartSchoolConstants.OPEN,pageable);
        return msgPage;
    }

   /* public Page<Contact> findMsgsWithOpenStatus(int pageNum, String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findOpenMsgs(
                SmartSchoolConstants.OPEN,pageable);
        return msgPage;
    }*/

    public boolean updateMsgStatus(int contactId /*,String updatedBy*/){
       /* boolean isUpdated = false;
        Optional<Contact> contact = contactRepository.findById(contactId);
        contact.ifPresent(contact1 -> {
            contact1.setStatus(SmartSchoolConstants.CLOSE);
            //contact1.setUpdatedBy(updatedBy);
            //contact1.setUpdatedAt(LocalDateTime.now());
        });
       int result = contactRepository.updateMsgStatus(contactId,SmartSchoolConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }

        Contact updatedContact = contactRepository.save(contact.get());
        if(null!=updatedContact && updatedContact.getUpdatedBy()!=null)
        {
            isUpdated = true;
        }
        return isUpdated;
*/
        boolean isUpdated = false;
        int rows = contactRepository.updateStatusById(SmartSchoolConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }


    /*public boolean updateMsgStatus(int contactId *//*,String updatedBy*//*){

        boolean isUpdated = false;
        int rows = contactRepository.updateMsgStatus(SmartSchoolConstants.CLOSE,contactId);
        if(rows > 0) {
            isUpdated = true;
        }
        return isUpdated;
    }*/

    /*public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }*/
}
