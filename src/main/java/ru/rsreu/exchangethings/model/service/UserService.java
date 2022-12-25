package ru.rsreu.exchangethings.model.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.UserStatusEnum;
import ru.rsreu.exchangethings.model.datalayer.DBType;
import ru.rsreu.exchangethings.model.datalayer.UserDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;
import ru.rsreu.exchangethings.model.datalayer.oracledb.UserDAOImpl;
import ru.rsreu.exchangethings.view.beans.ItemBean;
import ru.rsreu.exchangethings.view.beans.UserBean;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
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

    public void updateAllUserAuth() {
        try {
            userDAO.updateAllUserAuth();
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void updateUserAuth(int idUser, Boolean auth) {
        try {
            userDAO.updateUserAuth(idUser, auth);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }


    public List<UserBean> getUsersByAuthorizationStatus(boolean auth) {
        List<UserBean> users = new LinkedList<>();
        try {
            if (auth)
                userDAO.getUsersByAuthorizationStatus("1").forEach(userEntity -> users.add(new UserBean(userEntity)));
            else
                userDAO.getUsersByAuthorizationStatus("0").forEach(userEntity -> users.add(new UserBean(userEntity)));
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
        return users;
    }

    public void updateUser(UserBean userBean, String pass) {
        try {
            UserEntity userEntity = new UserEntity(
                    userBean.getId(),
                    userBean.getSurname(),
                    userBean.getName(),
                    userBean.getPatronymic(),
                    userBean.getLogin(),
                    pass,
                    null,
                    null,
                    0,
                    0
            );
            userDAO.updateUserInfo(userEntity);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }

    public void insertUser(
            String surname,
            String name,
            String patronymic,
            String login,
            String password,
            String isAuthorized,
            String lastLoginTime,
            int userRole,
            int userStatus
    ) {
        try {
            userDAO.insertUser(
                    surname,
                    name,
                    patronymic,
                    login,
                    password,
                    isAuthorized,
                    lastLoginTime,
                    userRole,
                    userStatus
            );
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        } catch (ParseException e) {
            logger.log(Level.WARNING, "PARSE EXCEPTION :" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int userId) {
        try {
            userDAO.deleteUser(userId);
        } catch (SQLException e) {
            logger.log(Level.WARNING, "SQL EXCEPTION :" + e.getMessage());
            throw new IncludeParameterException();
        }
    }
}
