package ru.rsreu.exchangethings.model.service;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;
import ru.rsreu.exchangethings.view.beans.UserBean;

public class UserService {
    public static UserService instance = new UserService();

    public UserBean login(String login, String password) {
        UserBean res = new UserBean();
        if (!password.equals("1")) throw new IncludeParameterException();
        switch (login) {
            case "user":
                res.setId(1);
                res.setLogin("user");
                res.setUserRole("user");
                break;
            case "moderator":
                res.setId(1);
                res.setLogin("moderator");
                res.setUserRole("moderator");
                break;
            case "admin":
                res.setId(1);
                res.setLogin("admin");
                res.setUserRole("admin");
                break;
            default:
                throw new IncludeParameterException();
        }
        return res;
    }
}
