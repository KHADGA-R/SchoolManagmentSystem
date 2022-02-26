package com.example.SMSBoot.controller;


import com.example.SMSBoot.models.Person;
import com.example.SMSBoot.models.Type;
import com.example.SMSBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value="/people")
@CrossOrigin("*")
public class PersonController {

    private PersonService ps;

    public PersonController(){

    }
    @Autowired
    public PersonController(PersonService ps){
        this.ps=ps;
    }

    //to map our request with the controller uri we use @PostMapping, @GetMapping, @PutMapping ...
    @PostMapping("/")
    @ResponseBody
    public Person createUser(@RequestBody Person p){
        //Here we would go about storing the person in our database
//        Person created = p;
//        created.setPersonId(1);
//        return created;
        return ps.createNewPerson(p.getPersonId(), p.getType(), p.getFirst(), p.getLast(), p.getPassword());
    }

    @GetMapping("/")
    @ResponseBody
    public List<Person> getAllPeople(){
//        List<Person>people = new ArrayList<>();
//        people.add(new Person(2, Type.TEACHER, "Khagendra", "Katwal", "khagendra.katwal@gmail.com", "password"));
//        people.add(new Person(3,Type.STUDENT, "Khadga", "Parajuli", "khadga.parajuli@revature.net", "newPass"));
//        return people;

        return ps.getALlPeople();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Person getPersonById(@PathVariable("id")int id){
//        Person p = (new Person(2, Type.TEACHER, "Khagendra", "Katwal", "khagendra.katwal@gmail.com", "password"));
//        return p;
        return ps.getPersonById(id);

    }
}
