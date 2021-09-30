package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Passport;
import com.example.universityjpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassportRepositoryTest {

    @Autowired
    private PassportRepository passportRepository;

    @Test
    @Transactional
    public void getPassportAndStudent(){

        Optional<Passport> passportOptional = passportRepository.findById(1L);
        System.out.println("passport = " + passportOptional.get());
        Student student = passportOptional.get().getStudent();
        System.out.println("student = " + student);
    }
}