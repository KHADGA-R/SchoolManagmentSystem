package com.example.SMSBoot.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="assignment_id")
    private int assignmentId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="student")
    @JsonIgnore
    private Person student;

    @Column(name="grade")
    private double grade;

    @Column(name="done")
    private boolean done;

    @Column(name="past_due")
    private boolean pastDue;

    @Column(name="due")
    private Date due;


    public Assignment(){

    }

    public Assignment(int assignmentId, Person student, double grade, boolean done, boolean pastDue, Date due) {
        this.assignmentId = assignmentId;
        this.student = student;
        this.grade = grade;
        this.done = done;
        this.pastDue = pastDue;
        this.due = due;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean isPastDue() {
        return pastDue;
    }

    public void setPastDue(boolean pastDue) {
        this.pastDue = pastDue;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId=" + assignmentId +
                ", student=" + student +
                ", grade=" + grade +
                ", done=" + done +
                ", pastDue=" + pastDue +
                ", due=" + due +
                '}';
    }
}
