package com.example.fuegoypan.dto;

public class AuthenticationRequest {
    private String name;
    private String password;

    // getters y setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}