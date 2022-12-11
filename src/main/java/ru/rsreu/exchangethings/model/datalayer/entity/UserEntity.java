package ru.rsreu.exchangethings.model.datalayer.entity;

import java.sql.Date;

public class UserEntity {

    private int userID;
    private String surname;
    private String name;
    private String patronymic;
    private String login;
    private String password;
    private String isAuthorized;
    private Date lastLoginTime;
    private int userRole;
    private int userStatus;

    public UserEntity(int id, String surname, String name, String patronymic, String login, String password,
                      String isAuthorized, Date lastLoginTime, int userRole, int userStatus) {
        this.userID = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.login = login;
        this.password = password;
        this.isAuthorized = isAuthorized;
        this.lastLoginTime = lastLoginTime;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(String isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public int getUserRole() {
        return userRole;
    }

    public void setUserRole(int userRole) {
        this.userRole = userRole;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userID=" + userID +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAuthorized='" + isAuthorized + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", userRole=" + userRole +
                ", userStatus=" + userStatus +
                '}';
    }
}
