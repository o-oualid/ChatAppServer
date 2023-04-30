package com.um5.iwam.g12.chatappserver.dto;

import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class PostDto {

    private long id;
    @NotBlank
    private String content;
    private long classroom_id;
    private long sender_id;
    private Date createdAt;
    private Date updatedAt;
    private boolean isPinned;

    public PostDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public long getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(long classroom_id) {
        this.classroom_id = classroom_id;
    }

    public long getSender_id() {
        return sender_id;
    }

    public void setSender_id(long sender_id) {
        this.sender_id = sender_id;
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
}
