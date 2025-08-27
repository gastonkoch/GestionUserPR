package com.creacionrelacionprueba.creacionrelacionprueba.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;

    @Column(nullable = false, unique = true)
    private Long courseCode;

    @Column(nullable = false)
    private String courseTitle;

    @Column(nullable = false)
    private Integer courseCredits;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "professor_Id",//nombre en la bd
            referencedColumnName = "professorId" //Nombre en el sistema

    )
    private Professor professor;
}
