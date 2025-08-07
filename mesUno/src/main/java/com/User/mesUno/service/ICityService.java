package com.User.mesUno.service;

import com.User.mesUno.service.dto.CityDto;

import java.util.List;

public interface ICityService {
    public List<CityDto> getCity();
    public CityDto getCityById(Long cityId);
    public void saveCity(CityDto city);
    public void deleteCity(Long cityId);
    public void updateCity(CityDto cityDto);
//    public void findAllCity();
}
