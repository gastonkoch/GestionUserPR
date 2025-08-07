package com.User.mesUno.repository;

import com.User.mesUno.domain.City;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CityRepositoryTest {
    @Autowired
    CityRepository cityRepository;

//    @Test
//    public void saveCity(){
//        City city = City.builder()
//                        .cityName("Tucuman")
//                        .build();
//
//        cityRepository.save(city);
//    }

    @Test
    public void findAllCity(){
        List<City> cityList = cityRepository.findAll();
        cityList.stream().forEach(System.out::print);
//        System.out.print(cityList);
    }

    @Test
    public void findAllWithUsers(){
        List<City> cityList = cityRepository.findAllWithUsers();

//        cityList.stream()
//                        .forEach(c -> System.out.print("C " + c));

        System.out.print("City con usuario: " + cityList);
    }
}