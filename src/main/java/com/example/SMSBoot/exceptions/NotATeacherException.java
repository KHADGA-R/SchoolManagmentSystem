package com.example.SMSBoot.exceptions;

public class NotATeacherException extends Exception {

    public NotATeacherException(){
        super("This person is not a teacher");
    }
}
