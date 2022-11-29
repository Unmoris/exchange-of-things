package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.entity.UserEntity;

import java.sql.SQLException;
        import java.text.ParseException;
        import java.util.List;

public interface ExchangeOfThingsDAO {

    List<UserEntity> getUsersByAuthorizationStatus(String authorizationStatus) throws SQLException, ParseException;
    //List<Employees> getEmployeesByDuty(String dutyTypeID) throws SQLException;
    //List<DutiesAmountByEachTypeDTO> getDutiesAmountByEachType() throws SQLException;

}

