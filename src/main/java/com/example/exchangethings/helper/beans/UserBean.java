package com.example.exchangethings.helper.beans;

import java.io.Serializable;

public class UserBean implements Serializable {
    private static final long serialVersionUID = 2041275512219239990L;

    private Integer id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;
    private String userRole;
    private String userStatus;

    public UserBean(Integer id, String login, String name, String surname, String patronymic, String userRole, String userStatus) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public UserBean() {
        id = -1;
        login = "";
        name = "";
        surname = "";
        patronymic = "";
        userRole = "";
        userStatus = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
