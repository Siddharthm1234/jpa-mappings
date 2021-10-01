package com.example.universityjpa;

import com.example.universityjpa.entity.Course;
import com.example.universityjpa.entity.Review;
import com.example.universityjpa.entity.Student;
import com.example.universityjpa.service.CourseReviewService;
import com.example.universityjpa.service.StudentCourseService;
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

	@Autowired
	private StudentCourseService studentCourseService;

	public static void main(String[] args) {
		SpringApplication.run(UniversityJpaApplication.class, args);
	}

	@Override
	public void run(String...args) throws Exception {

		//Review - Course Relation Insert
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

		//Student - Course Relation Insert
		Student student = Student.builder()
				.firstName("Gaurav")
				.lastName("Yadav")
				.emailId("gyadav@gmail.com")
				.build();

		Course course = Course.builder()
				.courseTitle("PE Course")
				.credit(1)
				.build();

		studentCourseService.addCourseForStudent(student, course);

	}


}
