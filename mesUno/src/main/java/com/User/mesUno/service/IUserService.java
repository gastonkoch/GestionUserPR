package com.User.mesUno.service;

import com.User.mesUno.service.dto.UserDto;

import java.util.List;

public interface IUserService {
    public List<UserDto> getUsers();
    public UserDto getUserById(Long userId);
    public void saveUser(UserDto user);
    public void deleteUser(Long userId);
    public void updateUser(UserDto userDto);
    List<UserDto> getUsersByCity(Long cityId);
}
