package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table
public class UserClassroom {

    @EmbeddedId
    private UserClassroomKey id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("userId")

    private User user;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @MapsId("classroomId")
    private Classroom classroom;

    @Temporal(TemporalType.TIMESTAMP)

    private Date joinedAt;
    @Enumerated(EnumType.ORDINAL)
    private UserRole role;

    @Column()
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public UserClassroom() {
    }

    public UserClassroom(Classroom classroom, User user, UserRole role, Status status) {
        this.id = new UserClassroomKey(user.getId(), classroom.getId());
        setRole(role);
        setStatus(status);
        this.joinedAt = new Date(System.currentTimeMillis());
        this.user= user;
        this.classroom= classroom;
    }


    public Date getJoinedAt() {
        return joinedAt;
    }

    public void setJoinedAt(Date joinedAt) {
        this.joinedAt = joinedAt;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
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

    public UserClassroomKey getId() {
        return id;
    }

    public void setId(UserClassroomKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

