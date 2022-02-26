package com.example.SMSBoot.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Entity
@Table(name="person")

public class Person {

    @Id
    @Column(name="personId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name="person_type", nullable = false)
    private Type type;

    @Column(name="first_name", nullable = false)
    private String first;

    @Column(name="last_name", nullable = false)
    private String last;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Assignment> assignments = new ArrayList<>();


    public Person(){

    }

    public Person(int Id, Type type, String first, String last, String email, String password){
        this.personId = Id;
        this.type = type;
        this.first= first;
        this.last = last;
        this.email= email;
        this.password = password;
        this.assignments = new ArrayList<>();

    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", type=" + type +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", assignments=" + assignments +
                '}';
    }
}
