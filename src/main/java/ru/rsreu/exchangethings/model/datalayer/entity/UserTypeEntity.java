package ru.rsreu.exchangethings.model.datalayer.entity;

public class UserTypeEntity {
    private int userTypeID;
    private String roleName;

    public UserTypeEntity(int userTypeID, String roleName) {
        this.userTypeID = userTypeID;
        this.roleName = roleName;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
