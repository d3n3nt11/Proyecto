package com.example.fuegoypan.repository;


import com.example.fuegoypan.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

    boolean existsByName(String name);

    Optional<User> findByName(String name);
}
