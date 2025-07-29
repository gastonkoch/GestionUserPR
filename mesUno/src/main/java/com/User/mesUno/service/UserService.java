package com.User.mesUno.service;

import com.User.mesUno.domain.Car;
import com.User.mesUno.domain.City;
import com.User.mesUno.domain.User;
import com.User.mesUno.exception.UserNotFoundException;
import com.User.mesUno.repository.CarRepository;
import com.User.mesUno.repository.CityRepository;
import com.User.mesUno.repository.UserRepository;
import com.User.mesUno.service.dto.CarDto;
import com.User.mesUno.service.dto.CityDto;
import com.User.mesUno.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .userEmail(user.getUserEmail())
                        .userPassword(user.getUserPassword())
                        .car(user.getCar() != null ? CarDto.builder()
                                .carId(user.getCar().getCarId())
                                .carName(user.getCar().getCarName())
                                .carBrand(user.getCar().getCarBrand())
                                .build() : null)
                        .city(user.getCity() != null ? CityDto.builder()
                                .cityId(user.getCity().getCityId())
                                .cityName(user.getCity().getCityName())
                                .build() : null)
                        .build())
                .toList();
//        return null;
    }


    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + userId));

        CarDto carDto = CarDto.builder()
                .carId(user.getCar().getCarId())
                .carName(user.getCar().getCarName())
                .carBrand(user.getCar().getCarBrand())
                .build();

        CityDto cityDto = CityDto.builder()
                .cityId(user.getCity().getCityId())
                .cityName(user.getCity().getCityName())
                .build();

        return UserDto.builder()
                .userId(user.getUserId())
                .userEmail(user.getUserEmail())
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .car(carDto)
                .city(cityDto)
                .build();
//        return null;
    }

    @Override
    public List<UserDto> getUsersByCity(Long cityId){

        City city = cityRepository.findById(cityId).orElseThrow(()-> new RuntimeException("No se encontro la ciudad con el id " + cityId));

        return userRepository.findByCity(city).stream()
                .map(user -> UserDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .userEmail(user.getUserEmail())
                        .userPassword(user.getUserPassword())
                        .city(CityDto.builder()
                                .cityId(user.getCity().getCityId())
                                .cityName(user.getCity().getCityName())
                                .build())
                        .car(CarDto.builder()
                                .carId(user.getCar().getCarId())
                                .carName(user.getCar().getCarName())
                                .carBrand(user.getCar().getCarBrand())
                                .build())
                        .build())
                .toList();
//        return null;
    }

    @Override
    public void saveUser(UserDto user) {
        userRepository.save(User.builder()
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .userEmail(user.getUserEmail())
                .car(user.getCar() != null ? Car.builder()
                        .carId(user.getCar().getCarId())
                        .carName(user.getCar().getCarName())
                        .carBrand(user.getCar().getCarBrand())
                        .build() : null)
                .city(user.getCity() != null ? City.builder()
                        .cityId(user.getCity().getCityId())
                        .cityName(user.getCity().getCityName())
                        .build() : null)
                .build());
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.findById(userId)
                .ifPresentOrElse(
                        userRepository::delete,
                        () -> { throw new UserNotFoundException("Usuario no encontrado con ID: " + userId); }
                );
    }

    @Override
    public void updateUser(UserDto userDto) {
        User user = userRepository.findById(userDto.getUserId())
                .orElseThrow(() -> new UserNotFoundException("Usuario con ID " + userDto.getUserId() + " no encontrado."));

        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setUserPassword(userDto.getUserPassword());

        City city = cityRepository.findById(userDto.getCity().getCityId())
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));

        Car car = carRepository.findById(userDto.getCar().getCarId())
                .orElseThrow(() -> new RuntimeException("Auto no encontrado"));

        user.setCity(city);
        user.setCar(car);

        userRepository.save(user);
    }

}


