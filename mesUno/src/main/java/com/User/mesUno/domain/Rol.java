package com.User.mesUno.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rol {
    @Id
    @SequenceGenerator(
            name = "rol_sequence",
            sequenceName = "rol_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "rol_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long rolId;
    private String rolName;
}
