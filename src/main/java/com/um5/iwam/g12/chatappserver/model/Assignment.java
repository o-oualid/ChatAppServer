package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.sql.Date;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Classroom classRoom;
    private Date dateCreated;
    @NotBlank
    private Date dueDate;
    @NotBlank
    private String content;

    public Assignment() {
    }

    public Assignment(Classroom classRoom, Date dueDate, String content) {
        this.classRoom = classRoom;
        this.dueDate = dueDate;
        this.content = content;
        dueDate = new Date(System.currentTimeMillis());
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Classroom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Classroom classRoom) {
        this.classRoom = classRoom;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
