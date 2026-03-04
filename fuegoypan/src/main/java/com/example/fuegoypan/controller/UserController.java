package com.example.fuegoypan.controller;


import com.example.fuegoypan.dto.UserCreateDTO;
import com.example.fuegoypan.dto.UserDTO;
import com.example.fuegoypan.model.User;
import com.example.fuegoypan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //Crear usuario
    @PostMapping
    public UserDTO createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return userService.createUser(userCreateDTO);
    }

    //Obtener todos los usuarios
    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    //Obtener por usuarios por ID
    @GetMapping("/{id}")
    public UserDTO getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    //desactivar usuario
    @PutMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable Long id) {
        userService.desactivateUser(id);
    }

    //activar usaurio
    @PutMapping("/{id}/activate")
    public void activateUser(@PathVariable Long id) {
        userService.activateUser(id);
    }

    @GetMapping("/me")
    public ResponseEntity<UserDTO> getMe(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(userService.getById(user.getId()));
    }
}
