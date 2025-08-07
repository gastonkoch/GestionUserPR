package com.User.mesUno.repository;

import com.User.mesUno.domain.Car;
import com.User.mesUno.exception.CarNotFoundException;
import com.User.mesUno.service.dto.CarDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarRepositoryTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    public void getCars() {
        List<CarDto> listCarDto = carRepository.findAll().stream()
                .map(car -> CarDto.builder()
                        .carId(car.getCarId())
                        .carName(car.getCarName())
                        .carBrand(car.getCarBrand())
                        .build())
                .toList();
        System.out.print("listCarDto " + listCarDto);
    }

    @Test
    public void getCarById() {
        Car car = carRepository.findById(2L)
                .orElseThrow(()-> new CarNotFoundException("Auto no encontrado con ID: " + 2L));

        CarDto carDto = CarDto.builder()
                .carId(car.getCarId())
                .carName(car.getCarName())
                .carBrand(car.getCarBrand())
                .build();

        System.out.print("carDto " + carDto);
    }

    @Test
    public void saveCar(){
        Car car = Car.builder()
                .carName("Cronos")
                .carBrand("Fiat")
                .build();

        carRepository.save(car);
    }
}