package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "First name is required")
    @Column(length = 45)
    private String firstName;
    @NotBlank(message = "Last name is required")
    @Column(length = 45)
    private String lastName;

    @Column(length = 100)
    private String handle;

    @Email(message = "Email should be valid")
    @Column(unique = true, length = 100)
    private String email;
    private boolean isEmailVerified;

    @NotBlank(message = "Password is required")
    @Column(length = 70)
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserRole type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(length = 100)
    private String profilePicture;

    @Column(length = 100)
    private String BackgroundPicture;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "sender")
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY)
    private List<UserClassroom> userClassrooms;

    public User() {

    }

    public User(String firstName, String lastName, String email, String password, String roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public UserRole getType() {
        return type;
    }

    public void setType(UserRole type) {
        this.type = type;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", handle='" + handle + '\'' + ", email='" + email + '\'' + ", isEmailVerified=" + isEmailVerified + ", type='" + type + '\'' + ", createdAt=" + createdAt + ", profilePicture='" + profilePicture + '\'' + ", BackgroundPicture='" + BackgroundPicture + '\'' + '}';
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<UserClassroom> getUserClassrooms() {
        return userClassrooms;
    }

    public void setUserClassrooms(List<UserClassroom> userClassrooms) {
        this.userClassrooms = userClassrooms;
    }


}

