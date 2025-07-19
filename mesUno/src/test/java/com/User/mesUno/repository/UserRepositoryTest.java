package com.User.mesUno.repository;

import com.User.mesUno.domain.Car;
import com.User.mesUno.domain.City;
import com.User.mesUno.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Autowired
    CityRepository cityRepository;

    @Test
    public void saveUser(){

//        Car car = Car.builder()
//                .carName("Palio")
//                .carBrand("Fiat")
//                .build();
//
//
//
//        User user = User.builder()
//                .userName("pepe")
//                .userEmail("pepe@gmail.com")
//                .userPassword("3333")
//                .car(car)
//                .build();
//
//        userRepository.save(user);

    }

    @Test
    public void getUsers(){
        List<User> userList = userRepository.findAll();
        userList.stream()
                .forEach(System.out::print);
    }

    @Test
    public void updateUser(){

        User user = userRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con ID"));



    }

    @Test
    public void assignUserCity(){
        User user = userRepository.findById(4L)
                .orElseThrow(() -> new RuntimeException("No se encontró el usuario con ID"));

//        user.setCity(City.builder().cityName("Santa Fe 2").build());
        City city = cityRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("No se encontró la ciudad con ID"));

        System.out.print("City " + city);
//       user.setCity(city);
//
//        userRepository.save(user);
    }

    @Test
    public void getUsersByCityId() {
        List<User> users = userRepository.findByCity_CityId(4L);
        users.forEach(System.out::println);
    }

    @Test
    public void getUsersByCity() {
        City city = cityRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        List<User> users = userRepository.findByCity(city);
        users.forEach(System.out::println);
    }


}