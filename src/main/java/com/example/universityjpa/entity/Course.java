package com.example.universityjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
@ToString(exclude = {"reviews", "students"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseTitle;
    private Integer credit;

    //FetchType is Lazy for Many side of entity in Many-to-One by default
    @OneToMany(mappedBy = "course")
    private Set<Review> reviews = new HashSet<>();

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    public void addStudent(Student student){
        if(this.students == null){
            this.students = new HashSet<>();
        }
        this.students.add(student);
    }

    public void removeStudent(Student student){
        this.students.remove(student);
    }

}
