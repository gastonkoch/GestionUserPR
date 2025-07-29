package com.User.mesUno.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private CarDto car;
    private CityDto city;
}
