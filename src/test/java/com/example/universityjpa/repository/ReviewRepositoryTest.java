package com.example.universityjpa.repository;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReviewRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    @Transactional
    public void addReviewsForCourse() {

        Optional<Course> courseOptional = courseRepository.findById(3L);

        Review review1 = Review.builder()
                .rating("2")
                .description("React is tuff")
                .course(courseOptional.get())
                .build();
        Review review2 = Review.builder()
                .rating("3")
                .description("React is ok")
                .course(courseOptional.get())
                .build();


        System.out.println("reviews = " + courseOptional.get().getReviews());


        //SETTING RELATIONSHIP BOTH WAYS
        courseOptional.get().addReview(review1);
        courseOptional.get().addReview(review2);

        review1.setCourse(courseOptional.get());
        review2.setCourse(courseOptional.get());

        //This wouldn't work. persist by Owner
        //courseRepository.save(courseOptional.get());

        reviewRepository.save(review1);
        reviewRepository.save(review2);
    }


    @Test
    public void retrieveCourseForReview(){
        Optional<Review> reviewOptional = reviewRepository.findById(3L);
        Course course = reviewOptional.get().getCourse();

        System.out.println("course = " + course);
    }

}