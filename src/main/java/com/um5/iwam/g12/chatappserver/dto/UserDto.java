package com.um5.iwam.g12.chatappserver.dto;

import com.um5.iwam.g12.chatappserver.model.UserType;

public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String handle;//TODO: is it necessary?
    private String email;

    private UserType type;

    private String profilePicture;

    private String BackgroundPicture;


}
