package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "classrooms")
public class Classroom {

    @Id
    @GeneratedValue
    private long id;

    @NotBlank
    @Column(length = 100)
    private String name;

    @Column(length = 300)
    private String subtitle;

    @Column(length = 1000)
    private String description;

    @Column(length = 100)
    private String backgroundPicture;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "classroom")
    private List<UserClassroom> userClassrooms;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "classroom")
    private List<Post> posts;


    public Classroom() {
    }

    public Classroom(long id, String name) {
        this.id = id;
        this.name = name;
        createdAt=new Date(System.currentTimeMillis());
        updatedAt=new Date(System.currentTimeMillis());
    }

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

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBackgroundPicture() {
        return backgroundPicture;
    }

    public void setBackgroundPicture(String backgroundPicture) {
        this.backgroundPicture = backgroundPicture;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
