package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.DateFormatter;
import ru.rsreu.exchangethings.model.datalayer.ExchangeOfThingsDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OracleDBExchangeOFThingsDAO implements ExchangeOfThingsDAO {

    private Connection connection;
    public OracleDBExchangeOFThingsDAO(Connection connection) {
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
    public List<UserEntity> getBlockedUsers(String blockedStatus) throws SQLException {
        String query = QueriesProperties.getProperty("BlockedUsers.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, blockedStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }

    /*@Override
    public List<RequestsEntity> getCanceledRequests(String requestStatus) throws SQLException {
        String query = QueriesProperties.getProperty("CanceledRequests.request");
        PreparedStatement preparedStatementUsers = this.getPreparedStatement(query);
        preparedStatementUsers.setString(1, requestStatus);
        ResultSet resultSet = preparedStatementUsers.executeQuery();
        return this.getUsersFromQuery(resultSet);
    }*/


    private  List<UserEntity> getUsersFromQuery(ResultSet resultSet) throws SQLException {
        List<UserEntity> users = new ArrayList<>();
        while (resultSet.next()) {
            UserEntity user =
                    new UserEntity(resultSet.getInt(EntitiesResource.getProperty("id")),
                            resultSet.getString(EntitiesResource.getProperty("surname")),
                            resultSet.getString(EntitiesResource.getProperty("name")),
                            resultSet.getString(EntitiesResource.getProperty("patronymic")),
                            resultSet.getString(EntitiesResource.getProperty("login")),
                            resultSet.getString(EntitiesResource.getProperty("password")),
                            resultSet.getString(EntitiesResource.getProperty("is_authorized")),
                            resultSet.getDate(EntitiesResource.getProperty("last_login_time")),
                            resultSet.getString(EntitiesResource.getProperty("user_role")),
                            resultSet.getString(EntitiesResource.getProperty("user_status")));
            users.add(user);
        }
        return users;
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
