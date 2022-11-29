package ru.rsreu.exchangethings.controller.commands.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ActionLogger {
    static public Logger logger = Logger.getLogger("Action Logger");

    static private String logAction(HttpServletRequest request, String nameParameter) {
        return (new StringBuilder())
                .append("Path: ")
                .append(request.getContextPath())
                .append(" ")
                .append(nameParameter)
                .append(" ")
                .append(request.getParameter(nameParameter))
                .toString();
    }

    static public void infoAction(HttpServletRequest request, String nameParameter) {
        logger.info(logAction(request, nameParameter));
    }

    static public Action emptyAction = (request, response) -> logger.info("empty action: " + request.getContextPath());
}
