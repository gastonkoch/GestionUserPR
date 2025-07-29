package com.User.mesUno.controller;

import com.User.mesUno.service.ICarService;
import com.User.mesUno.service.dto.CarDto;
import com.User.mesUno.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private ICarService carService;

    @GetMapping("/getAllCars")
    public ResponseEntity<List<CarDto>> getCars(){
        return ResponseEntity.ok(carService.getCars());
    }

    @GetMapping("/getCarById/{carId}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long carId) {
        return ResponseEntity.ok(carService.getCarById(carId));
    }

    @PostMapping("/saveCar")
    public ResponseEntity<String> saveUser(@RequestBody CarDto carDto) {
        carService.saveCar(carDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("El auto fue creado correctamente");
    }

    @DeleteMapping("/deleteCar/{carId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long carId) {
        carService.deleteCar(carId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateCar")
    public ResponseEntity<String> updateUser(@PathVariable CarDto carDto) {
        carService.updateCar(carDto);
        return ResponseEntity.ok("El auto fue actualizado correctamente");
    }

}
