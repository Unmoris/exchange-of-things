package ru.rsreu.exchangethings.model.service;

import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.datalayer.DBType;
import ru.rsreu.exchangethings.model.datalayer.UserDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;
import ru.rsreu.exchangethings.model.datalayer.oracledb.UserDAOImpl;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.sql.SQLException;
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
            System.out.println(user.getUserRole());
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return user;
    }
}
