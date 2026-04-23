package com.example.fuegoypan.service;


import com.example.fuegoypan.dto.AuthenticationRequest;
import com.example.fuegoypan.dto.AuthenticationResponse;
import com.example.fuegoypan.dto.UserCreateDTO;
import com.example.fuegoypan.model.User;
import com.example.fuegoypan.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserService userService,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Registro
    public AuthenticationResponse register(UserCreateDTO request) {
        // Crea el usuario y asigna Role.USER internamente
        var savedUserDTO = userService.createUser(request);

        // Obtén la entidad User completa
        User user = userService.getEntityById(savedUserDTO.getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado tras registro"));

        // Genera JWT
        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken, user.getRole().name());
    }

    // Login
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        // Autenticación Spring Security
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getName(),
                        request.getPassword()
                )
        );

        // Obtén el usuario
        User user = userService.getEntityByName(request.getName())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Genera JWT
        String jwtToken = jwtService.generateToken(user);

        return new AuthenticationResponse(jwtToken, user.getRole().name());// pasamos tambien el role del usuario
    }
}