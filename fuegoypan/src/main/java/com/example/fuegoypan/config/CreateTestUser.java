package com.example.fuegoypan.config;

import com.example.fuegoypan.model.Role;
import com.example.fuegoypan.model.User;
import com.example.fuegoypan.repository.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CreateTestUser implements CommandLineRunner {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public CreateTestUser(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        // 👇 USUARIO 1: yeray (CAMARERO) - El que ya tenías
        crearUsuarioSiNoExiste("yeray", "123456", Role.CAMARERO);

        // 👇 USUARIO 2: admin (ADMINISTRADOR) - Nuevo
        crearUsuarioSiNoExiste("admin", "admin123", Role.ADMIN);

        // 👇 USUARIO 3: gerente (GERENTE) - Nuevo
        crearUsuarioSiNoExiste("gerente", "gerente123", Role.GERENTE);

        System.out.println("✅ Proceso de creación de usuarios de prueba finalizado.");
    }

    // 👇 Método auxiliar para no repetir código (más limpio y mantenible)
    private void crearUsuarioSiNoExiste(String nombre, String passwordPlano, Role rol) {

        if (!userRepo.existsByName(nombre)) {

            User user = new User();
            user.setName(nombre);

            // 👇 ¡CLAVE! Encripta la contraseña con BCrypt
            user.setPassword(passwordEncoder.encode(passwordPlano));

            user.setRole(rol);
            user.setEnabled(true);  // 👇 Usuario activo por defecto

            userRepo.save(user);

            // 👇 Mensaje de confirmación en consola
            System.out.println("✅ Usuario creado:");
            System.out.println("   Nombre: " + nombre);
            System.out.println("   Contraseña: " + passwordPlano);
            System.out.println("   Rol: " + rol);
            System.out.println("   -------------------");

        } else {
            // 👇 Si ya existe, lo indicamos (útil para saber que no se duplica)
            System.out.println("ℹ️  Usuario '" + nombre + "' ya existe. Se omite.");
        }
    }
}