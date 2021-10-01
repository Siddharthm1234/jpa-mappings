package com.example.universityjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@ToString(exclude = {"passport", "courses"})
@EqualsAndHashCode(exclude="courses")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String emailId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="passport_id", unique = true)
    private Passport passport;

    @ManyToMany
    @JoinTable(
            name = "STUDENT_COURSE",
            joinColumns = @JoinColumn(name = "STUDENT_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID")
    )
    private Set<Course> courses = new HashSet<>();

    public void addCourse(Course course){
        if(this.courses == null){
            courses = new HashSet<>();
        }
        this.courses.add(course);
    }

    public void removeCourse(Course course){
        this.courses.remove(course);
    }


//    @Embedded
//    private Guardian guardian;
}
