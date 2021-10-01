package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Guardian;
import com.example.universityjpa.entity.Passport;
import com.example.universityjpa.entity.Student;
import com.example.universityjpa.service.StudentCourseService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.Entity;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@ComponentScan(basePackages = {"com.example.universityjpa.repository"})
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    @Transactional
    public void updateFirstNameByEmailId(){
        int updated = studentRepository.updateStudentNameByEmailId("Updated Sid", "random@gmail.com");
        System.out.println("updated = " + updated);
    }


    /*** ----- ONE TO ONE ------***/
    @Test
    @Transactional
    public void getStudentAndPassport(){
        Optional<Student> studentOptional1 = studentRepository.findById(1L);
        System.out.println("student = " + studentOptional1.get());
        Passport passport = studentOptional1.get().getPassport();
        System.out.println("passport = " + passport);
    }


    /*** ----- ONE TO ONE ------***/
    @Test
    @Transactional
    public void getAllStudentAndPassport(){
        List<Student> students = studentRepository.findAll();
        System.out.println("students = " + students);
    }

    /*** ----- MANY TO ONE ------***/
    @Test
    @Transactional
    public void getStudentAndCourse(){
        Optional<Student> studentOptional = studentRepository.findById(1L);
        Set<Course> courses = studentOptional.get().getCourses();
        System.out.println("courses = " + courses);
    }


    @Test
    public void getStudentsWithNoCourse(){
        List<Student> students = studentRepository.findByCoursesIsNull();
        System.out.println("students = " + students);
    }

}