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
@ToString(exclude = {"review"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private String courseTitle;
    private Integer credit;

    //FetchType is Lazy for Many side of entity in Many-to-One by default
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    private Set<Review> reviews = new HashSet<>();

    public void addReview(Review review){
        this.reviews.add(review);
    }

    public void removeReview(Review review){
        this.reviews.remove(review);
    }

}
