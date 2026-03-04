package com.example.fuegoypan.service.impl;


import com.example.fuegoypan.dto.UserCreateDTO;
import com.example.fuegoypan.dto.UserDTO;
import com.example.fuegoypan.model.User;
import com.example.fuegoypan.repository.UserRepo;
import com.example.fuegoypan.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    //private final Cloudinary cloudinary;

    public UserServiceImpl(UserRepo userRepo,
                           PasswordEncoder passwordEncoder
                         ) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;

    }
    @Override
    public UserDTO createUser(UserCreateDTO dto) {

        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre es obligatorio");
        }

        if (dto.getPassword() == null || dto.getPassword().length() < 6) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La contraseña debe tener al menos 6 caracteres");
        }

        if (userRepo.existsByName(dto.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya está registrado");
        }

        User user = new User();
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setProfilePhoto(dto.getProfilePhoto());
        user.setRole(dto.getRole());
        User saved = userRepo.save(user);

        return mapToDTO(saved);
    }

    @Override
    public UserDTO uploadProfilePhoto(Long userId, MultipartFile file) {
        throw new UnsupportedOperationException("Funcionalidad aún no implementada");
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepo.findAll()
                .stream()
                .filter(User::isEnabled)
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getById(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));


        return mapToDTO(user);
    }

    @Override
    public Optional<User> getEntityByName(String name) {
        return userRepo.findByName(name);
    }

    @Override
    public Optional<User> getEntityById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public void desactivateUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        user.setEnabled(false);   // Bloquea login
        userRepo.save(user);
    }

    @Override
    public void activateUser(Long id) {
        User user = userRepo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        user.setEnabled(true);
        userRepo.save(user);
    }

    //convertir Entidad → DTO
    private UserDTO mapToDTO(User user) {

        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setProfilePhoto(user.getProfilePhoto());
        dto.setRegister_at(user.getRegisterAt());
        dto.setRole(user.getRole());

        return dto;
    }

}
