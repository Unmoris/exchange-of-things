package ru.rsreu.exchangethings.controller.commands;

import ru.rsreu.exchangethings.helper.Helper;
import ru.rsreu.exchangethings.exceptions.IncludeParameterException;
import ru.rsreu.exchangethings.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ActionViewCommand implements ActionCommand {
    public ActionViewCommand(View view, View errorView, Helper helper) {
        this.view = view;
        this.helper = helper;
        this.errorView = errorView;
    }

    public ActionViewCommand(View commonView, Helper helper) {
        this.view = commonView;
        this.helper = helper;
        this.errorView = commonView;
    }

    private View view;
    private View errorView;

    private Helper helper;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder loggerMessage = new StringBuilder();
        loggerMessage.append("Path: ")
                .append(request.getContextPath())
                .append(" show: ")
                .append(request.getParameter("command"));

        logger.info(loggerMessage.toString());
        try {
            helper.includeParamsInScopes(request, response);
            view.show(request, response);
        } catch (IncludeParameterException e) {
            errorView.show(request, response);
        }
    }
}
