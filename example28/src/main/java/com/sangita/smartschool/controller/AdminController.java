package com.sangita.smartschool.controller;

import com.sangita.smartschool.model.SmartClass;
import com.sangita.smartschool.model.Person;
import com.sangita.smartschool.repository.SmartClassRepository;
import com.sangita.smartschool.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

    @Autowired
    SmartClassRepository smartClassRepository;

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/displayClasses")
    public ModelAndView displayClasses(Model model) {
        List<SmartClass> smartClasses = smartClassRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("classes.html");
        modelAndView.addObject("smartClasses",smartClasses);
        modelAndView.addObject("smartClass", new SmartClass());
        return modelAndView;
    }

    @PostMapping("/addNewClass")
    public ModelAndView addNewClass(Model model, @ModelAttribute("smartClass") SmartClass smartClass) {
        smartClassRepository.save(smartClass);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

    @RequestMapping("/deleteClass")
    public ModelAndView deleteClass(Model model, @RequestParam int id) {
        Optional<SmartClass> smartClass = smartClassRepository.findById(id);
        for(Person person : smartClass.get().getPersons()){
            person.setSmartClass(null);
            personRepository.save(person);
        }
        smartClassRepository.deleteById(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
        return modelAndView;
    }

   @GetMapping("/displayStudents")
    public ModelAndView displayStudents(Model model, @RequestParam int classId, HttpSession session,
                                        @RequestParam(value = "error", required = false) String error) {
        String errorMessage = null;
        ModelAndView modelAndView = new ModelAndView("students.html");
        Optional<SmartClass> smartClass = smartClassRepository.findById(classId);
        modelAndView.addObject("smartClass",smartClass.get());
        modelAndView.addObject("person",new Person());
        session.setAttribute("smartClass",smartClass.get());
        if(error != null) {
            errorMessage = "Invalid Email entered!!";
            modelAndView.addObject("errorMessage", errorMessage);
        }
        return modelAndView;
    }

    @PostMapping("/addStudent")
    public ModelAndView addStudent(Model model, @ModelAttribute("person") Person person, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        SmartClass smartClass = (SmartClass) session.getAttribute("smartClass");
        Person personEntity = personRepository.readByEmail(person.getEmail());
        if(personEntity==null || !(personEntity.getPersonId()>0)){
            modelAndView.setViewName("redirect:/admin/displayStudents?classId="+smartClass.getClassId()
                    +"&error=true");
            return modelAndView;
        }
        personEntity.setSmartClass(smartClass);
        personRepository.save(personEntity);
        smartClass.getPersons().add(personEntity);
        smartClassRepository.save(smartClass);
        modelAndView.setViewName("redirect:/admin/displayStudents?classId="+smartClass.getClassId());
        return modelAndView;
    }

    @GetMapping("/deleteStudent")
    public ModelAndView deleteStudent(Model model, @RequestParam int personId, HttpSession session) {
        SmartClass smartClass = (SmartClass) session.getAttribute("smartClass");
        Optional<Person> person = personRepository.findById(personId);
        person.get().setSmartClass(null);
        smartClass.getPersons().remove(person.get());
        SmartClass smartClassSaved = smartClassRepository.save(smartClass);
        session.setAttribute("smartClass",smartClassSaved);
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayStudents?classId="+smartClass.getClassId());
        return modelAndView;
    }
}
