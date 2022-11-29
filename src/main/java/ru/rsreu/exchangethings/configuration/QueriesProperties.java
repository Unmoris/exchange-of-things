package ru.rsreu.exchangethings.configuration;

import java.util.ResourceBundle;

public class QueriesProperties {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("queries");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    private QueriesProperties() {
    }
}
