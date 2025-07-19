package com.User.mesUno.service;

import com.User.mesUno.domain.User;
import com.User.mesUno.exception.UserNotFoundException;
import com.User.mesUno.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll().stream()
                .map(user -> UserDto.builder()
                        .userId(user.getUserId())
                        .userName(user.getUserName())
                        .userEmail(user.getUserEmail())
                        .userPassword(user.getUserPassword())
                        .build())
                .toList();
    }

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + userId));

        return UserDto.builder()
                .userId(user.getUserId())
                .userEmail(user.getUserEmail())
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .build();
    }

    @Override
    public void saveUser(UserDto user) {
        userRepository.save(User.builder()
                .userName(user.getUserName())
                .userPassword(user.getUserPassword())
                .userEmail(user.getUserEmail())
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
        userRepository.findById(userDto.getUserId())
                .map(user -> {
                    user.setUserName(userDto.getUserName());
                    user.setUserEmail(userDto.getUserEmail());
                    user.setUserPassword(userDto.getUserPassword());
                    return user;
                })
                .map(userRepository::save)
                .orElseThrow(() -> new UserNotFoundException("Usuario con ID " + userDto.getUserId() + " no encontrado."));
    }
}


