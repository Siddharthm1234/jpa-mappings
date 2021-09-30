package com.example.universityjpa.service;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Review;
import com.example.universityjpa.repository.CourseRepository;
import com.example.universityjpa.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.Set;

@Service
public class CourseReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Transactional
    public void addReviewsForCourse(Long courseId, Set<Review> reviewSet) {

        Optional<Course> courseOptional = courseRepository.findById(courseId);

        //SETTING RELATIONSHIP BOTH WAYS
        for(Review review : reviewSet){
            courseOptional.get().addReview(review);
            review.setCourse(courseOptional.get());

            reviewRepository.save(review);
        }
    }
}
