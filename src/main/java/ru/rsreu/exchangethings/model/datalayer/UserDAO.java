package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.UserRoleEnum;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * DAO user interface
 */
public interface UserDAO {
    /**
     * Method that allows view currently authorized/unauthorized users:
     * @param authorizationStatus
     * @return
     * @throws SQLException
     */
    List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException;

    /**
     * Method that allows view users for a specific period
     * @param lastLoginTime
     * @return
     * @throws SQLException
     * @throws ParseException
     */
    List<UserEntity> getUsersByLastLoginTime(String lastLoginTime) throws SQLException, ParseException;
    //Просмотр заблокированных пользователей
    List<UserEntity> getBlockedUsers(int blockedStatus) throws SQLException;

    /**
     * View users by role
     * @param role
     * @return
     * @throws SQLException
     */
    List<UserEntity> getAllByRole(int role) throws SQLException;

    /**
     * Adding a user
     * @throws SQLException
     * @throws ParseException
     */
    void insertUser(String surname, String name, String patronymic,
                    String login, String password, String isAuthorized,
                    String lastLoginTime, int userRole, int userStatus)  throws SQLException, ParseException;

    /**
     *Update user by status
     * @param userStatus
     * @param userId
     * @throws SQLException
     */
    void updateUserStatus(int userStatus, int userId) throws SQLException;

    /**
     * Deleting a user
     * @param userId
     * @throws SQLException
     */
    void deleteUser(int userId) throws SQLException;

    /**
     * User login
     * @param login
     * @param password
     * @return
     * @throws SQLException
     */
    UserEntity loginUser(String login, String password) throws SQLException;

    /**
     * Get User By Id
     * @param id
     * @return
     * @throws SQLException
     */
    UserEntity getUserById(int id) throws SQLException;

    /**
     * Update All User Auth
     * @throws SQLException
     */
    void updateAllUserAuth() throws SQLException;

    /**
     * Update User Auth
     * @param idUser
     * @param auth
     * @throws SQLException
     */
    void updateUserAuth(int idUser, Boolean auth) throws SQLException;

    /**
     * Update User Info
     * @param userEntity
     * @throws SQLException
     */
    void updateUserInfo(UserEntity userEntity) throws SQLException;
}
