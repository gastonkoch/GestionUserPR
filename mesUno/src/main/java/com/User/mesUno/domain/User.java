package com.User.mesUno.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "tbl_user")
@Table(
        name = "tbl_user",
//      Sin esta restriccion el usuario puede tener un auto y el auto un usuario, pero se puede asignar el mismo auto a otro usuario
        uniqueConstraints = @UniqueConstraint(
                name = "user_car_id_car_not_repeat_user", //  nombre personalizado de la constraint
                columnNames = "car_id"
        )
)
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;

//    // Se entiende que un usuario puede poseer más de un auto, pero se hace con fines de realizar una relacion OneToOne
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "car_id",
            referencedColumnName = "carId"
    )
    private Car car;

//    @ManyToOne(
//            cascade = CascadeType.ALL
//    )
    @ManyToOne
    @JoinColumn(
            name = "city_id",
            referencedColumnName = "cityId"
    )
    private City city;

    @Override
    public String toString() {
        return " User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", car='" + car + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
