package ru.rsreu.exchangethings.security.token;

import ru.rsreu.exchangethings.model.UserRoleEnum;

public class TokenInfo {

    public TokenInfo(int userId, UserRoleEnum userRole) {
        this.userId = userId;
        this.userRole = userRole;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserRoleEnum getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleEnum userRole) {
        this.userRole = userRole;
    }

    private int userId;
    private UserRoleEnum userRole;
}
