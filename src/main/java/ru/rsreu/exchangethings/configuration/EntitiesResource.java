package ru.rsreu.exchangethings.configuration;

import java.util.ResourceBundle;

public class EntitiesResource {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("entities");
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    private EntitiesResource() {
    }
}
