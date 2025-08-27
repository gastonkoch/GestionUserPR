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
public class Office {
    @Id
    @SequenceGenerator(
            name = "office_sequence",
            sequenceName = "office_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "office_sequence"
    )
    private Long officeId;

    @Column(nullable = false)
    private String officeBuilding;

    @Column(nullable = false)
    private Integer officeRoomNumber;
}
