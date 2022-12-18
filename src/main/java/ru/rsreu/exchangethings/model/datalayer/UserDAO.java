package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface UserDAO {
    //Просмотр авторизованных/неавторизованных пользователей в данный момент:
    List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException;
    //Просмотр пользователей за определенный период
    List<UserEntity> getUsersByLastLoginTime(String lastLoginTime) throws SQLException, ParseException;
    //Просмотр заблокированных пользователей
    List<UserEntity> getBlockedUsers(int blockedStatus) throws SQLException;
    void insertUser(String surname, String name, String patronymic,
                    String login, String password, String isAuthorized,
                    String lastLoginTime, int userRole, int userStatus)  throws SQLException, ParseException;

    void updateUserStatus(int userStatus, int userId) throws SQLException;
    void deleteUser(int userId) throws SQLException;

    UserEntity loginUser(String login, String password) throws SQLException;

    UserEntity getUserById(int id) throws SQLException;
}
