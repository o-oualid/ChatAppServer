package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {


    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User sender;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public Comment() {
    }

    public Comment(User sender, String content, Post post) {
        this.sender = sender;
        this.content = content;
        this.post = post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
}
