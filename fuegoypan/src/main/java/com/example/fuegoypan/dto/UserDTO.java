package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.Role;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;
    private String name;
    private String profilePhoto;
    private LocalDateTime register_at;
    private Role role;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public LocalDateTime getRegister_at() {
        return register_at;
    }

    public void setRegister_at(LocalDateTime register_at) {
        this.register_at = register_at;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
