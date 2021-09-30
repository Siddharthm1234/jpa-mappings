package com.example.universityjpa.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@ToString(exclude = {"passport"})
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

//    @Embedded
//    private Guardian guardian;
}
