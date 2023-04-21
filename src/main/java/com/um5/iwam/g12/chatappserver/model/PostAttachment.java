package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table
public class PostAttachment {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String type;

    private String url;

    private Date createdAt;

    private int downloadCount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    public PostAttachment() {
    }

    public PostAttachment(long id, String name, String type, String url, Date createdAt, Post post) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.url = url;
        this.createdAt = createdAt;
        this.post = post;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
