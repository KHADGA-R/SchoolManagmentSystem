package com.example.SMSBoot.controller;


import com.example.SMSBoot.exceptions.NotATeacherException;
import com.example.SMSBoot.models.Course;
import com.example.SMSBoot.models.Person;
import com.example.SMSBoot.services.CourseService;
import com.example.SMSBoot.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

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

    @PutMapping("/teacher")
    //We have these objects called ResponseEntity, which allow to set things like the response status as well as the body
    public ResponseEntity<Object> addTeacherToCourse(@RequestBody LinkedHashMap<String, Integer> body){

        System.out.println(body);

        Course c = cs.getCourseById(body.get("courseId"));
        Person t = ps.getPersonById(body.get("teacherId"));

        try {
            c = cs.assignTeacher(c, t);
        }catch (NotATeacherException e){
            return new ResponseEntity<>("This is not a teacher", HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>(c, HttpStatus.ACCEPTED);
    }

    @PutMapping("/students")
    public Course addStudentsToCourse(@RequestBody LinkedHashMap<String, List<Person>> students, @RequestParam("courseId") int courseId) {

        Course c = cs.getCourseById(courseId);

        List<Person> s = students.get("students");

        Person[] pList = new Person[s.size()];

        for(int i=0; i<s.size(); i++){
            pList[i]= s.get(i);
        }

        cs.addStudents(c, pList);

        return cs.getCourseById(courseId);

    }


}
