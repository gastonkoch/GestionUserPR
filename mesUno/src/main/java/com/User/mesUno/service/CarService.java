package com.User.mesUno.service;

import com.User.mesUno.domain.Car;
import com.User.mesUno.domain.User;
import com.User.mesUno.exception.CarNotFoundException;
import com.User.mesUno.exception.CityNotFoundException;
import com.User.mesUno.repository.CarRepository;
import com.User.mesUno.service.dto.CarDto;
import com.User.mesUno.service.dto.CityDto;
import com.User.mesUno.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService implements ICarService{
    @Autowired
    private CarRepository carRepository;

    @Override
    public List<CarDto> getCars() {
        return carRepository.findAll().stream()
                .map(car -> CarDto.builder()
                        .carId(car.getCarId())
                        .carName(car.getCarName())
                        .carBrand(car.getCarBrand())
                        .build())
                .toList();
    }

    @Override
    public CarDto getCarById(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(()-> new CarNotFoundException("Auto no encontrado con ID: " + carId));

        return CarDto.builder()
                .carId(car.getCarId())
                .carName(car.getCarName())
                .carBrand(car.getCarBrand())
                .build();

    }

    @Override
    public void saveCar(CarDto carDto) {
        carRepository.save(Car.builder()
                .carId(carDto.getCarId())
                .carName(carDto.getCarName())
                .carBrand(carDto.getCarBrand())
                .build());
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.findById(carId)
                .ifPresentOrElse(
                        carRepository::delete,
                        () -> { throw new CarNotFoundException("Auto no encontrado con ID: " + carId); }
                );
    }

    @Override
    public void updateCar(CarDto carDto) {
        Car car = carRepository.findById(carDto.getCarId())
                .orElseThrow(()-> new CarNotFoundException("Auto no encontrado con ID: " + carDto.getCarId()));

        car.setCarName(carDto.getCarName());
        car.setCarBrand(carDto.getCarBrand());

        carRepository.save(car);
    }
}
