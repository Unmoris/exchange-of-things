package ru.rsreu.exchangethings.configuration;

import java.util.ResourceBundle;

public class JspResource {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("jsp");

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

    private JspResource() {
    }

}
