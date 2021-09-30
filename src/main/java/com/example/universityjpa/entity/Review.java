package com.example.universityjpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
@ToString(exclude={"course"})
@EqualsAndHashCode(exclude="course")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    private String rating;

    private String description;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
