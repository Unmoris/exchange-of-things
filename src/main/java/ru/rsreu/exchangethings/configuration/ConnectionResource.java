package ru.rsreu.exchangethings.configuration;

import java.util.ResourceBundle;

public class ConnectionResource {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("connection");
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    private ConnectionResource() {
    }
}
