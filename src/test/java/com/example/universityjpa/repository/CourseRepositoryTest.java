package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;


@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    @Transactional
    public void retrieveReviewsForCourse(){
        Optional<Course> courseOptional = courseRepository.findById(3L);
        Set<Review> reviews = courseOptional.get().getReviews();

        System.out.println("reviews = " + reviews);
    }

}