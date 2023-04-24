package com.um5.iwam.g12.chatappserver.dto;

import jakarta.validation.constraints.NotBlank;

public class ClassDto {
    private long id;
    @NotBlank
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
