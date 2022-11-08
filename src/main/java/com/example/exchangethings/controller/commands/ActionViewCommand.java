package com.example.exchangethings.controller.commands;

import com.example.exchangethings.helper.Helper;
import com.example.exchangethings.view.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class ActionViewCommand implements ActionCommand {
    public ActionViewCommand(View view, Helper helper) {
        this.view = view;
        this.helper = helper;
    }

    private View view;

    private Helper helper;
    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        StringBuilder loggerMessage = new StringBuilder();
        loggerMessage.append("Path: ")
                .append(request.getContextPath())
                .append(" show: ")
                .append(view.getClass().getName());

        logger.info(loggerMessage.toString());

        helper.includeParamsInScopes(request, response);
        view.show(request, response);
    }
}
