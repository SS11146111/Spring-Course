package com.sangita.smartschool.service;

import com.sangita.smartschool.constants.SmartSchoolConstants;
import com.sangita.smartschool.model.Person;
import com.sangita.smartschool.model.Roles;
import com.sangita.smartschool.repository.PersonRepository;
import com.sangita.smartschool.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RolesRepository rolesRepository;

    public boolean createNewPerson(Person person){
        boolean isSaved = false;
        Roles role = rolesRepository.getByRoleName(SmartSchoolConstants.STUDENT_ROLE);
        person.setRoles(role);
        person = personRepository.save(person);
        if (null != person && person.getPersonId() > 0)
        {
            isSaved = true;
        }
        return isSaved;
    }
}
