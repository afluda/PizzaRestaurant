package com.example.pizzeramorebackend.controllers;


import com.example.pizzeramorebackend.dto.UserDTO.UserDTO;
import com.example.pizzeramorebackend.mapper.UserMapper;
import com.example.pizzeramorebackend.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;


    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        List<UserDTO> clientList = userService.getAllUsers().stream().map(userMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(clientList);
    }

    @PostMapping
    public ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO user) {
        UserDTO createdClient = userMapper.toDTO(userService.saveUser(userMapper.fromDTO(user)));
        return ResponseEntity.status(201).body(createdClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable String id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(userMapper.toDTO(userService.getUserById(id)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable String id, @Valid @RequestBody UserDTO user) {
        userService.updateUser(userMapper.fromDTO(user));
        return ResponseEntity.ok(userMapper.toDTO(userService.getUserById(id)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable String id) {
        userService.getUserById(id);
        return ResponseEntity.ok(userMapper.toDTO(userService.getUserById(id)));
    }
}
