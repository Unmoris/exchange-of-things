package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.DateFormatter;
import ru.rsreu.exchangethings.model.datalayer.UserDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException {
        String query = QueriesProperties.getProperty("UsersByAuthorizationStatus.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, authorizationStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<UserEntity> getUsersByLastLoginTime(String lastLoginTime) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("UsersByLastLoginTime.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setDate(1, DateFormatter.getSimpleDateFormatTime(lastLoginTime));
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<UserEntity> getBlockedUsers(int blockedStatus) throws SQLException {
        String query = QueriesProperties.getProperty("BlockedUsers.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setInt(1, blockedStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public List<UserEntity> getAllByRole(int role) throws SQLException {
        String query = QueriesProperties.getProperty("SelectUsersByRole");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setInt(1, role);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    @Override
    public void insertUser(String surname, String name, String patronymic,
                           String login, String password, String isAuthorized,
                           String lastLoginTime, int userRole, int userStatus) throws SQLException, ParseException {
        String query = QueriesProperties.getProperty("InsertUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, surname);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, patronymic);
        preparedStatement.setString(4, login);
        preparedStatement.setString(5, password);
        preparedStatement.setString(6, isAuthorized);
        preparedStatement.setDate(7, DateFormatter.getSimpleDateFormatTime(lastLoginTime));
        preparedStatement.setInt(8, userRole);
        preparedStatement.setInt(9, userStatus);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserStatus(int userStatus, int userId) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateUserStatus.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userStatus);
        preparedStatement.setInt(2, userId);
        preparedStatement.executeUpdate();
    }

    @Override
    public void deleteUser(int userId) throws SQLException {
        String query = QueriesProperties.getProperty("DeleteUser.request");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(1, userId);
        preparedStatement.executeUpdate();
    }

    @Override
    public UserEntity loginUser(String login, String password) throws SQLException {
        String query = QueriesProperties.getProperty("Login.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, login);
        preparedStatementUsers.setString(2, password);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        resultSet.next();
        return this.getUserEntity(resultSet);
    }

    @Override
    public UserEntity getUserById(int id) throws SQLException {
        String query = QueriesProperties.getProperty("GetUserById.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setInt(1, id);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        resultSet.next();
        return this.getUserEntity(resultSet);
    }

    @Override
    public void updateAllUserAuth() throws SQLException {
        String query = QueriesProperties.getProperty("UpdateUsersAuth");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserAuth(int idUser,  Boolean auth) throws SQLException {
        String query = QueriesProperties.getProperty("UpdateUsersAuthById");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setInt(2, idUser);
        if (auth){
            preparedStatement.setString(1, "1");
        }else {
            preparedStatement.setString(1, "0");
        }
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUserInfo(UserEntity userEntity) throws SQLException {
        String query = QueriesProperties.getProperty("updateUser");
        PreparedStatement preparedStatement = this.getPreparedStatement(query);
        preparedStatement.setString(1, userEntity.getSurname());
        preparedStatement.setString(2, userEntity.getName());
        preparedStatement.setString(3, userEntity.getPatronymic());
        preparedStatement.setString(4, userEntity.getLogin());
        preparedStatement.setString(5, userEntity.getPassword());
        preparedStatement.setInt(6, userEntity.getUserID());
        preparedStatement.executeUpdate();
    }

    private List<UserEntity> getUsersFromQuery(ResultSet resultSet) throws SQLException {
        List<UserEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity user = this.getUserEntity(resultSet);
            users.add(user);
        }
        return users;
    }

    private UserEntity getUserEntity(ResultSet resultSet) throws SQLException {
        return new UserEntity(resultSet.getInt(EntitiesResource.getProperty("id")),
                resultSet.getString(EntitiesResource.getProperty("surname")),
                resultSet.getString(EntitiesResource.getProperty("name")),
                resultSet.getString(EntitiesResource.getProperty("patronymic")),
                resultSet.getString(EntitiesResource.getProperty("login")),
                resultSet.getString(EntitiesResource.getProperty("password")),
                resultSet.getString(EntitiesResource.getProperty("is_authorized")),
                resultSet.getDate(EntitiesResource.getProperty("last_login_time")),
                resultSet.getInt(EntitiesResource.getProperty("user_role")),
                resultSet.getInt(EntitiesResource.getProperty("user_status")));
    }

    private PreparedStatement getPreparedStatement(String sqlQuery) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
