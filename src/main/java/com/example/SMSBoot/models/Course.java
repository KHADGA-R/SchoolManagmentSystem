package com.example.SMSBoot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="courses")
public class Course {

    @Id
    @Column(name="course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @Column(name="subject")
    private String subject;

    @Column(name="course_number")
    private int number;

    @Column(name="course_name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="teacher")
    private Person teacher;

    @ElementCollection
    @CollectionTable(name="topics", joinColumns = @JoinColumn(name="course_id"))
    @Column(name="topic")
    private List<String> topics;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="student_course_junction",
            joinColumns = {@JoinColumn(name="course_id")},
            inverseJoinColumns = {@JoinColumn(name="person_id")}
    )
    private List<Person>students;

    public Course(){
        this.topics = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public Course(int courseId,String subject, int number, String name){
        this.courseId = courseId;
        this.subject = subject;
        this.number = number;
        this.name = name;
        this.topics = new ArrayList<>();
        this.students = new ArrayList<>();

    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher() {
        this.teacher = teacher;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<Person> getStudents() {
        return students;
    }

    public void setStudents(List<Person> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", subject='" + subject + '\'' +
                ", number=" + number +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                ", topics=" + topics +
                ", students=" + students +
                '}';
    }

    public void setTeacher(Person t) {
    }
}
