package com.example.SMSBoot.controller;


import com.example.SMSBoot.models.Course;
import com.example.SMSBoot.services.CourseService;
import com.example.SMSBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService cs;
    private PersonService ps;

    @Autowired
    public CourseController(CourseService cs, PersonService ps) {
        this.cs = cs;
        this.ps = ps;
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course c){
        return cs.createNewCourse(c.getCourseId(), c.getSubject(), c.getNumber(), c.getName());
    }


}
