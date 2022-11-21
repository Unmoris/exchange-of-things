package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.oracledb.OracleDBExchangeOFThingsDAO;

public abstract class DAOFactory {
    public static DAOFactory getInstance(DBType dbType) {
        DAOFactory result = dbType.getDAOFactory();
        return result;
    }

    public abstract OracleDBExchangeOFThingsDAO getOracleDBExchangeOFThingsDAO();

}


