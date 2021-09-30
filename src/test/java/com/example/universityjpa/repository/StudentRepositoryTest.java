package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Guardian;
import com.example.universityjpa.entity.Passport;
import com.example.universityjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void updateFirstNameByEmailId(){
        int updated = studentRepository.updateStudentNameByEmailId("Updated Sid", "random@gmail.com");
        System.out.println("updated = " + updated);
    }


    @Test
    @Transactional
    public void getStudentAndPassport(){
        Optional<Student> studentOptional1 = studentRepository.findById(1L);
        System.out.println("student = " + studentOptional1.get());
        Passport passport = studentOptional1.get().getPassport();
        System.out.println("passport = " + passport);
    }



    @Test
    @Transactional
    public void getAllStudentAndPassport(){
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }


}