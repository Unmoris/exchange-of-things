package ru.rsreu.exchangethings.model.datalayer.oracledb;

import ru.rsreu.exchangethings.configuration.ConnectionResource;
import ru.rsreu.exchangethings.configuration.JspResource;
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
        String url = ConnectionResource.getProperty("db.url");
        String user = ConnectionResource.getProperty("db.user");
        String password = ConnectionResource.getProperty("db.password");
        connection = DriverManager.getConnection(url, user, password);
        System.out.println("Connected to oracle DB!");
    }

    @Override
    public UserDAOImpl getUserDAOImpl() {
        return new UserDAOImpl(connection);
    }
    @Override
    public ItemDAOImpl getItemDAOImpl() {
        return new ItemDAOImpl(connection);
    }
    @Override
    public RequestDAOImpl getRequestDAOImpl() {
        return new RequestDAOImpl(connection);
    }

}

