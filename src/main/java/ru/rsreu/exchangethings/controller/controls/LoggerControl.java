package ru.rsreu.exchangethings.controller.controls;

import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

public class LoggerControl {
    static public Logger logger = Logger.getLogger("Action Logger");

    static private String logControl(HttpServletRequest request, String nameParameter) {
        return (new StringBuilder())
                .append("Path: ")
                .append(request.getContextPath())
                .append(" ")
                .append(nameParameter)
                .append(" ")
                .append(request.getParameter(nameParameter))
                .toString();
    }

    static public void infoControl(HttpServletRequest request, String nameParameter) {
        logger.info(logControl(request, nameParameter));
    }

    static public Control emptyControl = (request, response) -> logger.info("empty control: " + request.getContextPath());
}
