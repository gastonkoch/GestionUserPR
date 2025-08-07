package com.User.mesUno.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_user_course"
)
public class UserCourse {
    @Id
    @SequenceGenerator(
            name = "user_course_sequence",
            sequenceName = "user_course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_course_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long userCourseId;

    @Column(
            name = "user_course_date_create",
            nullable = false
    )
    private LocalDateTime userCourseDateCreate;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id",
            nullable = false
    )
    private Course course;
}
