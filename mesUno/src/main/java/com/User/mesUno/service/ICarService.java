package com.User.mesUno.service;

import com.User.mesUno.service.dto.CarDto;
import com.User.mesUno.service.dto.CityDto;

import java.util.List;

public interface ICarService {
    public List<CarDto> getCars();
    public CarDto getCarById(Long carId);
    public void saveCar(CarDto carDto);
    public void deleteCar(Long carId);
    public void updateCar(CarDto carDto);
}
