package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.model.datalayer.DAOFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class OracleDBDAOFactory extends DAOFactory {
    private static volatile OracleDBDAOFactory instance;
    private Connection connection;

    private OracleDBDAOFactory() {
    }

    public static OracleDBDAOFactory getInstance()
            throws ClassNotFoundException, SQLException {
        OracleDBDAOFactory factory = instance;
        if (instance == null) {
            synchronized (OracleDBDAOFactory.class) {
                instance = factory = new OracleDBDAOFactory();
                factory.connected();
            }
        }
        return factory;
    }

    private void connected() throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        //Resourcer resourcer = ProjectResourcer.getInstance();
        //String url = resourcer.getString("db.url");
        String url = "db.url";
        String user = "db.user";
        String password = "db.password";
                //String user = resourcer.getString("db.user");
        //String password = resourcer.getString("db.password");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to oracle DB!");
    }

    @Override
    public OracleDBExchangeOFThingsDAO getOracleDBExchangeOFThingsDAO() {
        return new OracleDBExchangeOFThingsDAO(connection);
    }

}

