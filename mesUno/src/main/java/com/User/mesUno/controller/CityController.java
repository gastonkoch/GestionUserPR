package com.User.mesUno.controller;

import com.User.mesUno.service.ICityService;
import com.User.mesUno.service.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController{
    @Autowired
    private ICityService cityService;

    @GetMapping("/getAllCity")
    private ResponseEntity<List<CityDto>> getCity(){
        return ResponseEntity.ok(cityService.getCity());
    }

    @GetMapping("/getCityById/{cityId}")
    private ResponseEntity<CityDto> getCityById(@PathVariable Long cityId){
        return ResponseEntity.ok(cityService.getCityById(cityId));
    }

    @PostMapping("/saveCity/{cityId}")
    private ResponseEntity<String> saveCity(@RequestBody CityDto cityDto){
        return ResponseEntity.status(HttpStatus.CREATED).body("Ciudad creada con exito");
    }

    @DeleteMapping("/deleteCity/{cityId}")
    private ResponseEntity<String> deleteCity(@PathVariable Long cityId){
        cityService.deleteCity(cityId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateCity")
    private ResponseEntity<String> updateCity(@RequestBody CityDto cityDto){
        cityService.updateCity(cityDto);
        return ResponseEntity.ok("La ciudad fue modificada con exito");
    }

}

