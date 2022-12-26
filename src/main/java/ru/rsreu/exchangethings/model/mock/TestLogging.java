package ru.rsreu.exchangethings.model.mock;

import java.util.logging.Logger;

public class TestLogging {
    protected Logger logger = Logger.getLogger(this.getClass().getName());
    public boolean login(String username, String password) {
        boolean isLogging = username.equals("user") && password.equals("1");
        logger.info("login :" + isLogging);
        return isLogging;
    }

}
