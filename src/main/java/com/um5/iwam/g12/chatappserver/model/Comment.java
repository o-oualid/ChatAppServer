package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    @Column(length = 300)
    private String content;

    private int likes;

    @Temporal(TemporalType.DATE)
    private Date createdAt;

    @Temporal(TemporalType.DATE)

    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment() {
    }

    public Comment(User sender, String content, Post post) {
        this.sender = sender;
        this.content = content;
        this.post = post;
        createdAt=new Date(System.currentTimeMillis());
        updatedAt=new Date(System.currentTimeMillis());
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
}
