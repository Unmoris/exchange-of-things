package com.example.exchangethings.configuration;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceJsp {
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("jsp");

    // класс извлекает информацию из файла messages.properties
    private ResourceJsp() {
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
