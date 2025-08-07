package com.User.mesUno.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_city")
public class City {
    @Id
    @SequenceGenerator(
            name = "city_sequence",
            sequenceName = "city_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "city_sequence",
            strategy = GenerationType.SEQUENCE
    )
    public Long cityId;
    public String cityName;

    @OneToMany(
            mappedBy = "city",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
//            fetch = FetchType.LAZY
    )
    private List<User> users;

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", users=" + users +
                '}';
    }
}
