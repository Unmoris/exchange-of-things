package ru.rsreu.exchangethings.configuration;

import java.util.ResourceBundle;

public class JspResource {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("jsp");

    // класс извлекает информацию из файла messages.properties
    private JspResource() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
