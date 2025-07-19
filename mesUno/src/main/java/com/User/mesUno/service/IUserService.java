package com.User.mesUno.service;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<UserDto> getUsers();
    public UserDto getUserById(Long userId);
    public void saveUser(UserDto user);
    public void deleteUser(Long userId);
    public void updateUser(UserDto userDto);
}
