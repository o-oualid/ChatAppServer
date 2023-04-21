package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table
public class UserClassroom {

    @EmbeddedId
    UserClassroomKey id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("classroomId")
    private Classroom classroom;

    Date joinedAt;
    private String role;

    @Column()
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public UserClassroom() {
    }

    public UserClassroom(User user, Classroom classroom, Date joinedAt, String role, Status status) {
        this.user = user;
        this.classroom = classroom;
        this.joinedAt = joinedAt;
        this.role = role;
        this.status = status;
    }


    public Date getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Date joinedAt) {
        this.joinedAt = joinedAt;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}

