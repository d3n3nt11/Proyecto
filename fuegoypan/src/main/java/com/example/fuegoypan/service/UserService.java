package com.example.fuegoypan.service;


import com.example.fuegoypan.dto.UserCreateDTO;
import com.example.fuegoypan.dto.UserDTO;
import com.example.fuegoypan.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //Servicio de crear usuario.
    UserDTO createUser(UserCreateDTO userCreateDTO);

    UserDTO uploadProfilePhoto(Long userId, MultipartFile file);

    //Servicio de obtener todos.
    List<UserDTO> getAll();

    //Servicio de obtener por id.
    UserDTO getById(Long id);

    //Servicio de obtener por entidad.
    Optional<User> getEntityById(Long id);

    //Servicio de Activar usuario
    void activateUser(Long id);

    //Servicio de desactivar usuario.
    void desactivateUser(Long id);

    //Obtener por email
    Optional<User> getEntityByName(String name);
}
