package com.um5.iwam.g12.chatappserver.dto;

public class AuthDto {
    private String token;

    public AuthDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
