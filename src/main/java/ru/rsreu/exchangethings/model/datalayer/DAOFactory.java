package ru.rsreu.exchangethings.model.datalayer;

import ru.rsreu.exchangethings.model.datalayer.oracledb.ItemDAOImpl;
import ru.rsreu.exchangethings.model.datalayer.oracledb.RequestDAOImpl;
import ru.rsreu.exchangethings.model.datalayer.oracledb.UserDAOImpl;

public abstract class DAOFactory {
    public static DAOFactory getInstance(DBType dbType) {
        DAOFactory result = dbType.getDAOFactory();
        return result;
    }

    public abstract UserDAOImpl getUserDAOImpl();
    public abstract ItemDAOImpl getItemDAOImpl ();
    public abstract RequestDAOImpl getRequestDAOImpl();

}


