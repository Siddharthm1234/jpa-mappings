package com.example.universityjpa.service;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Student;
import com.example.universityjpa.repository.CourseRepository;
import com.example.universityjpa.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
public class StudentCourseService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void addCourseForStudent(Student student, Course course) {

        //ADD RELATION

        course.addStudent(student);
        student.addCourse(course);

        //Add entites in respective table
        courseRepository.save(course);
        studentRepository.save(student);

    }
}
