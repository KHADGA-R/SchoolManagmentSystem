package com.example.SMSBoot.services;

import com.example.SMSBoot.exceptions.NotATeacherException;
import com.example.SMSBoot.models.Course;
import com.example.SMSBoot.models.Person;
import com.example.SMSBoot.models.Type;
import com.example.SMSBoot.repository.CourseDao;
import com.example.SMSBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
@Transactional
public class CourseService {

    private CourseDao cd;
    private PersonRepository pr;

    public CourseService (){}

    @Autowired
    public CourseService(CourseDao cd, PersonRepository pr){
        this.cd=cd;
        this.pr=pr;
    }

    public Course createNewCourse(int id, String subject, int number, String name){
        Course c = new Course();
        c.setCourseId(id);
        c.setSubject(subject);
        c.setNumber(number);
        c.setName(name);
        return cd.save(c);
    }

    public Course assignTeacher(Course c, Person t) throws NotATeacherException {
        if(t.getType() != Type.TEACHER){
            throw new NotATeacherException();
        }
        c.setTeacher();
        return cd.save(c);

    }

    public Course addStudents(Course c, Person... p){
        List<Person> students = c.getStudents();

        Collections.addAll(students, p);

        c.setStudents(students);

        return cd.save(c);
    }

    public Course addTopic(Course c, String... topics){
        List<String> topicList = c.getTopics();
        Collections.addAll(topicList, topics);

        c.setTopics(topicList);
        return cd.save(c);
    }

    public List<Course> getAllCourses(){
        return cd.findAll();
    }

    public Course getCourseById(int id){
        return cd.getById(id);
    }
}
