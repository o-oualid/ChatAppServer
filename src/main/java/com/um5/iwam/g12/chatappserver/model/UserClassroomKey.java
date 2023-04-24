package com.um5.iwam.g12.chatappserver.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserClassroomKey implements Serializable {
    private Long userId;

    private Long classroomId;

    public UserClassroomKey() {
    }

    public UserClassroomKey(Long userId, Long classroomId) {
        this.userId = userId;
        this.classroomId = classroomId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Long classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserClassroomKey that)) return false;
        return Objects.equals(userId, that.userId) && Objects.equals(classroomId, that.classroomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, classroomId);
    }
}
