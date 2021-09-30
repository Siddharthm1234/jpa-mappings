package com.example.universityjpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "passport")
@ToString(exclude = {"student"})
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long passportId;

    private String passportNumber;

    //Put variable name on the Owning side - in mappedBy
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;
}
