package ru.rsreu.exchangethings.model.datalayer.entity;

public class UserStatus {

    private int userStatusID;
    private String userStatusName;

    public UserStatus(int userStatusID, String userStatusName) {
        this.userStatusID = userStatusID;
        this.userStatusName = userStatusName;
    }

    public int getUserStatusID() {
        return userStatusID;
    }

    public void setUserStatusID(int userStatusID) {
        this.userStatusID = userStatusID;
    }

    public String getUserStatusName() {
        return userStatusName;
    }

    public void setUserStatusName(String userStatusName) {
        this.userStatusName = userStatusName;
    }
}
