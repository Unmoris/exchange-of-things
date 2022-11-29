package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.EntitiesResource;
import ru.rsreu.exchangethings.configuration.QueriesProperties;
import ru.rsreu.exchangethings.model.datalayer.ExchangeOfThingsDAO;
import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                            resultSet.getString(EntitiesResource.getProperty("last_login_time")),
                            resultSet.getString(EntitiesResource.getProperty("role_name")),
                            resultSet.getString(EntitiesResource.getProperty("user_status_name")));
            users.add(user);
        }
        return users;
    }
/*
    @Override
    public List<Employees> getEmployeesByDuty(String dutyTypeID) throws SQLException {
        int dutyID = Integer.parseInt(dutyTypeID);
        String query = resourcer.getString("EmployeesByDuty.request");
        List<Employees> employeesByDuty = new ArrayList<>();
        PreparedStatement preparedStatementEmployees = this.getPreparedStatement(query);
        preparedStatementEmployees.setInt(1, dutyID);
        ResultSet resultSet = preparedStatementEmployees.executeQuery();
        while (resultSet.next()) {
            Employees employees =
                    new Employees(resultSet.getInt(resourcer.getString("EmployeeID")),
                            resultSet.getString(resourcer.getString("Surname")),
                            resultSet.getString(resourcer.getString("Firstname")),
                            resultSet.getString(resourcer.getString("Lastname")),
                            resultSet.getString(resourcer.getString("Post")));
            employeesByDuty.add(employees);
        }
        return employeesByDuty;
    }

    @Override
    public List<DutiesAmountByEachTypeDTO> getDutiesAmountByEachType() throws SQLException {
        String query = resourcer.getString("DutiesAmountByEachType.request");
        List<DutiesAmountByEachTypeDTO> dutiesAmountByEachType = new ArrayList<>();
        PreparedStatement preparedStatementDutiesAmount = this.getPreparedStatement(query);
        ResultSet resultSet = preparedStatementDutiesAmount.executeQuery();
        while (resultSet.next()) {
            DutiesAmountByEachTypeDTO dutiesAmountByEachTypeDTO =
                    new DutiesAmountByEachTypeDTO(resultSet.getInt(resourcer.getString("Duty_TypeID")),
                            resultSet.getString(resourcer.getString("Definition")),
                            resultSet.getInt(resourcer.getString("Duties_Amount")));
            dutiesAmountByEachType.add(dutiesAmountByEachTypeDTO);
        }
        return dutiesAmountByEachType;



    }*/

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
