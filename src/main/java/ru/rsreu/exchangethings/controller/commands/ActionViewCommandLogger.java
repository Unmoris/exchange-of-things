package ru.rsreu.exchangethings.controller.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ActionViewCommandLogger implements ActionCommand {
    protected Logger logger = Logger.getLogger(this.getClass().getName());

    private String logMessage(HttpServletRequest request) {
        return "Path: " +
                request.getContextPath() +
                " command: " +
                request.getParameter("command");

    }

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        logger.info(logMessage(request));
    }
}
