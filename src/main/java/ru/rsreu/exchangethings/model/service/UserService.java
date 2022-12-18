package ru.rsreu.exchangethings.model.service;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.UserStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.DBType;
import ru.rsreu.exchangethings.model.datalayer.UserDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;
import ru.rsreu.exchangethings.model.datalayer.oracledb.UserDAOImpl;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserService {
    public static UserService instance = new UserService();

    private static Logger logger = Logger.getLogger("User Service");
    private static UserDAO userDAO = DBType.ORACLE.getDAOFactory().getUserDAOImpl();

    public UserBean login(String login, String password) {
        UserBean user;
        try {
            user = new UserBean(userDAO.loginUser(login, password));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return user;
    }

    public UserBean getUserById(int id) {
        UserBean user;
        try {
            user = new UserBean(userDAO.getUserById(id));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return user;
    }

    public void setStatusUser(int id, UserStatusEnum statusEnum) {
        try {
            userDAO.updateUserStatus(statusEnum.order, id);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public List<UserBean> getAllUsersByRole(UserRoleEnum role) {
        List<UserBean> users = new LinkedList<>();
        try {
            userDAO.getAllByRole(role.order)
                    .stream()
                    .filter(Objects::nonNull)
                    .forEach(userEntity -> users.add(new UserBean(userEntity)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return users;
    }

}
