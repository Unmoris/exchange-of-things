package ru.rsreu.exchangethings.view.beans;

import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.UserStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.io.Serializable;

public class UserBean implements Serializable {
    private Integer id;
    private String login;
    private String name;
    private String surname;
    private String patronymic;

    private String isAuthorized;
    private String userRole;
    private String userStatus;

    public UserBean(Integer id, String login, String name, String surname, String patronymic, String isAuthorized, String userRole, String userStatus) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.isAuthorized = isAuthorized;
        this.userRole = userRole;
        this.userStatus = userStatus;
    }

    public UserBean() {
        id = 0;
        login = null;
        name = null;
        surname = null;
        patronymic = null;
        userRole = null;
        userStatus = null;
    }

    public UserBean(UserEntity userEntity) {
        id = userEntity.getUserID();
        login = userEntity.getLogin();
        name = userEntity.getName();
        surname = userEntity.getSurname();
        patronymic = userEntity.getPatronymic();
        userRole = UserRoleEnum.getRole(userEntity.getUserRole()).publicName;
        userStatus = UserStatusEnum.getStatus(userEntity.getUserStatus()).publicName;
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

    public String getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(String isAuthorized) {
        this.isAuthorized = isAuthorized;
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
