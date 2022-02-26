package com.example.SMSBoot.repository;

import com.example.SMSBoot.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {


}
