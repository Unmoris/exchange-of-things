package ru.rsreu.exchangethings.model.mock;

import java.util.Objects;
import java.util.logging.Logger;

public class TestLogging {
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    public boolean login(String username, String password) {
        boolean isLogging = username.equals("m.lapkin") && password.equals("123");
        logger.info("login :" + isLogging);
        return isLogging;
    }
}
