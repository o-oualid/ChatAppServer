package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classRoom;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "post")
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private boolean isPinned;

    @ManyToOne(fetch = FetchType.LAZY)
    private Classroom classroom;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    private List<PostAttachment> attachments;


    public Post() {
        super();
    }

    public Post(User sender, Classroom classRoom, List<Comment> comments, String content) {
        this.sender = sender;
        this.classRoom = classRoom;
        this.content = content;
        createdAt = new Date(System.currentTimeMillis());
        updatedAt = new Date(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Classroom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Classroom classRoom) {
        this.classRoom = classRoom;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public boolean isPinned() {
        return isPinned;
    }

    public void setPinned(boolean pinned) {
        isPinned = pinned;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public List<PostAttachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<PostAttachment> attachments) {
        this.attachments = attachments;
    }

}
