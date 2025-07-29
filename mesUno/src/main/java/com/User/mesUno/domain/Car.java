package com.User.mesUno.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_car")
@ToString(exclude = "user")
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "car_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long carId;
    private String carName;
    private String carBrand;

//    // Se entiende que un usuario puede poseer más de un auto, pero se hace con fines de realizar una relacion OneToOne
//    @OneToOne(
//            mappedBy = "car",
//            fetch = FetchType.LAZY
//    )
//    private User user;
}
