package com.example.SMSBoot.repository;

import com.example.SMSBoot.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    //Custom query to ge a user by email

    Person findPersonByEmail(String email);


}
