package com.User.mesUno.service;

import com.User.mesUno.domain.City;
import com.User.mesUno.exception.CityNotFoundException;
import com.User.mesUno.repository.CityRepository;
import com.User.mesUno.repository.UserRepository;
import com.User.mesUno.service.dto.CityDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<CityDto> getCity() {
        return cityRepository.findAll().stream()
                .map(city -> CityDto.builder()
                        .cityId(city.getCityId())
                        .cityName(city.getCityName())
                        .build())
                .toList();
//        return null;
    }

    @Override
    public CityDto getCityById(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new CityNotFoundException("Ciudad no encontrado con ID: " + cityId));

        return CityDto.builder()
                .cityId(city.getCityId())
                .cityName(city.getCityName())
                .build();
//        return null;
    }

    @Override
    public void saveCity(CityDto city) {
        cityRepository.save(City.builder()
                    .cityId(city.getCityId())
                    .cityName(city.getCityName())
                    .build());
    }

    @Override
    public void deleteCity(Long cityId) {
        cityRepository.findById(cityId)
                .ifPresentOrElse(
                        cityRepository::delete,
                        () -> { throw new CityNotFoundException("Ciduad no encontrado con ID: " + cityId); }
                );
    }

    @Override
    public void updateCity(CityDto cityDto) {
        City city = cityRepository.findById(cityDto.getCityId())
                .orElseThrow(() -> new CityNotFoundException("Ciduad no encontrado con ID: " + cityDto.getCityId()));

        city.setCityName(cityDto.getCityName());

        cityRepository.save(city);

    }
}
