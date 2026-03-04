package com.example.fuegoypan.dto;

import com.example.fuegoypan.model.Role;

public class UserCreateDTO {
    private String name;
    private String password;
    private String profilePhoto;
    private Role role;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
