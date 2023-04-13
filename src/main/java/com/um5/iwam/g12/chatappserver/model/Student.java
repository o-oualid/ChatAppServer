package com.um5.iwam.g12.chatappserver.model;

import jakarta.validation.constraints.NotEmpty;

public record Student(
        String id,
        @NotEmpty(message = "First name is required")
        String firstName,
        String lastName) {
}
