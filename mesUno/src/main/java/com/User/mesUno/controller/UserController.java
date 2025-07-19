package com.User.mesUno.controller;

import com.User.mesUno.domain.User;
import com.User.mesUno.exception.UserNotFoundException;
import com.User.mesUno.service.IUserService;
import com.User.mesUno.service.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping("/saveUser")
    public ResponseEntity<String> saveUser(@RequestBody UserDto user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado correctamente");
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateUser")
    public ResponseEntity<String> updateUser(@RequestBody UserDto user) {
        userService.updateUser(user);
        return ResponseEntity.ok("Usuario actualizado correctamente");
    }
}
