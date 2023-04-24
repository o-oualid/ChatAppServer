package com.um5.iwam.g12.chatappserver.dto;

import com.um5.iwam.g12.chatappserver.model.UserRole;

public class UserDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String handle;//TODO: is it necessary?
    private String email;

    private UserRole type;

    private String profilePicture;

    private String BackgroundPicture;

    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRole getType() {
        return type;
    }

    public void setType(UserRole type) {
        this.type = type;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getBackgroundPicture() {
        return BackgroundPicture;
    }

    public void setBackgroundPicture(String backgroundPicture) {
        BackgroundPicture = backgroundPicture;
    }
}
