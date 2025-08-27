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

public class Enrollment {
    @Id
    @SequenceGenerator(
            name = "enrollment_sequence",
            sequenceName = "enrollment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "enrollment_sequence"
    )
    private Long enrollmentId;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "student_id",//nombre en la bd
            referencedColumnName = "studentId" //Nombre en el sistema

    )
    private Student student;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "course_id",//nombre en la bd
            referencedColumnName = "courseId" //Nombre en el sistema
    )
    private Course course;

    private Integer enrollmentGrade;
}
