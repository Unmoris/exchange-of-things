package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.model.datalayer.ExchangeOfThingsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class OracleDBExchangeOFThingsDAO implements ExchangeOfThingsDAO {

    private Connection connection;
    //private Resourcer resourcer;

    public OracleDBExchangeOFThingsDAO(Connection connection) {
        this.connection = connection;
        //this.resourcer = ProjectResourcer.getInstance();
    }


    /*@Override
    public List<DutiesCompletedBySpecificDateDTO> getDutiesCompletedBySpecificDate(String endDate) throws SQLException, ParseException {
        String query = resourcer.getString("DutiesCompletedBySpecificDate.request");
        List<DutiesCompletedBySpecificDateDTO> dutiesCompletedBySpecificDate = new ArrayList<>();
        PreparedStatement preparedStatementDuties = this.getPreparedStatement(query);
        preparedStatementDuties.setDate(1, DateFormatter.getSimpleDateFormatTime(endDate));
        ResultSet resultSet = preparedStatementDuties.executeQuery();
        while (resultSet.next()) {
            DutiesCompletedBySpecificDateDTO dutiesCompletedBySpecificDateDTO =
                    new DutiesCompletedBySpecificDateDTO(resultSet.getString(resourcer.getString("Definition")),
                            resultSet.getDate(resourcer.getString("End_date")));
            dutiesCompletedBySpecificDate.add(dutiesCompletedBySpecificDateDTO);
        }
        return dutiesCompletedBySpecificDate;
    }

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
