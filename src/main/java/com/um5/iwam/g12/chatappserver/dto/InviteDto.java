package com.um5.iwam.g12.chatappserver.dto;

public class InviteDto {
    private String userEmail;
    private long classroomId;

    public InviteDto(String userEmail, long classroomId) {
        this.userEmail = userEmail;
        this.classroomId = classroomId;
    }

    public InviteDto() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public long getClassroomId() {
        return classroomId;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setClassroomId(long classroomId) {
        this.classroomId = classroomId;
    }
}
