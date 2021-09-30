package com.example.universityjpa;

import com.example.universityjpa.entity.Review;
import com.example.universityjpa.service.CourseReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class UniversityJpaApplication implements CommandLineRunner{

	@Autowired
	private CourseReviewService courseReviewService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityJpaApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {

		Set<Review> reviewSet = new HashSet<>();
		Review review1 = Review.builder()
				.rating("2")
				.description("React is tuff")
				.build();
		Review review2 = Review.builder()
				.rating("3")
				.description("React is ok")
				.build();

		reviewSet.add(review1);
		reviewSet.add(review2);
		courseReviewService.addReviewsForCourse(3L, reviewSet);
	}


}
